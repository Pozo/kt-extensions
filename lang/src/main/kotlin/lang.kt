@Target(AnnotationTarget.FUNCTION,
        AnnotationTarget.PROPERTY,
        AnnotationTarget.PROPERTY_GETTER,
        AnnotationTarget.PROPERTY_SETTER)
@Retention(AnnotationRetention.BINARY)
internal annotation class InlineOnly

@InlineOnly
inline fun <T> T?.applyIfNotNull(block: T.() -> Unit): T? {
    return this?.apply {
        block()
    }
}

@InlineOnly
inline fun <T, R> T?.runIfNotNull(block: T.() -> R): R? {
    return this?.run {
        block()
    }
}
@InlineOnly
inline fun <T> T?.ifNull(function: () -> T): T {
    if (this != null) {
        return this
    } else {
        return function()
    }
}