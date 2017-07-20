import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

inline fun <reified T> Gson.fromJson(readText: String): T {
    return fromJson<T>(readText, object : TypeToken<T>() {}.type)
}