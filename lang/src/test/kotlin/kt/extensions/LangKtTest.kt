package kt.extensions

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

    @Test(expected = IllegalArgumentException::class)
    fun `employee name is null`() {
        // GIVEN
        // this imitates a GSON parsing process
        val employee = EmployeeFactory.createEmployeeWithoutName()
//        the problem in this case that the compiler gonna
//        ignore ? anyway so there will be a NullPointerException
//        employee.name?.apply {
//            print(length)
//        }

        // WHEN

        employee.name.letIfNotNull {
            it
        }.ifNull { throw IllegalArgumentException("lol") }
        // THEN IllegalArgumentException
    }

    @Test
    fun `employee name is not null`() {
        // GIVEN
        val defaultValue = "b"
        val employee = EmployeeFactory.createEmployee()
        // WHEN

        val name = employee.name.letIfNotNull {
            it
        }.ifNull {
            defaultValue
        }

        // THEN
        Assert.assertEquals(EmployeeFactory.EMPLOYEE_NAME, name)
    }
}