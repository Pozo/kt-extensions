import org.junit.Assert
import org.junit.Test

class LangKtTest {
    @Test
    fun `list is null`() {
        // GIVEN
        val defaultValue = "b"
        val list: List<String>? = ValuesForTest.nullList()

        // WHEN
        val result: String = list.runIfNotNull { get(0) }.ifNull { defaultValue }

        // THEN
        Assert.assertEquals(defaultValue, result)
    }

    @Test
    fun `list is not null with null value`() {
        // GIVEN
        val defaultValue = "b"
        val list = ValuesForTest.listWithNullValue()

        // WHEN
        val result: String = list.runIfNotNull { get(0) }.ifNull { defaultValue }

        // THEN
        Assert.assertEquals(defaultValue, result)
    }

    @Test
    fun `list is not null with not null value`() {
        // GIVEN
        val defaultValue = "b"
        val list = ValuesForTest.listWithOneValue()

        // WHEN
        val result: String = list.runIfNotNull { get(0) }.ifNull { defaultValue }

        // THEN
        Assert.assertEquals(ValuesForTest.LIST_ELEMENT, result)
    }
}