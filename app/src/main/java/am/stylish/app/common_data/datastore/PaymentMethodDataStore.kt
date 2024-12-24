package am.stylish.app.common_data.datastore

import am.stylish.app.add_payment_method.domain.model.PaymentMethod
import am.stylish.app.add_payment_method.domain.model.PaymentMethodType
import am.stylish.app.common_domain.utils.Result
import android.content.Context
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map
import org.json.JSONException
import org.json.JSONObject

private val Context.dataStore by preferencesDataStore(name = "payment_methods")

class PaymentMethodDataStore(private val context: Context) {
    private val paymentMethodKey = stringPreferencesKey("payment_methods")

    fun savePaymentMethod(paymentMethod: PaymentMethod) = flow<Result> {
        context.dataStore.edit { preferences ->
            val currentMethodsJson = preferences[paymentMethodKey] ?: "{}"
            val currentMethods = deserializeMethods(currentMethodsJson).toMutableMap()
            currentMethods[paymentMethod.value] = paymentMethod.type.name
            preferences[paymentMethodKey] = serializeMethods(currentMethods)
        }
        emit(Result.Success("Success"))
    }.catch {
        emit(Result.Error("Failed to save payment method"))
    }

    val paymentMethods: Flow<List<PaymentMethod>> = context.dataStore.data
        .map { preferences ->
            val methodsJson = preferences[paymentMethodKey] ?: "{}"
            deserializeMethods(methodsJson).map { (key, value) ->
                PaymentMethod(value = key, type = PaymentMethodType.valueOf(value))
            }
        }

    private fun serializeMethods(methods: Map<String, String>): String {
        return JSONObject(methods).toString()
    }

    private fun deserializeMethods(json: String): Map<String, String> {
        return try {
            val jsonObject = JSONObject(json)
            jsonObject.keys().asSequence().associateWith { jsonObject.getString(it) }
        } catch (e: JSONException) {
            emptyMap()
        }
    }
}
