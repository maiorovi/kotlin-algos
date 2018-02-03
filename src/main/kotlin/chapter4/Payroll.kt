package chapter4

import chapter2.Person

object Payroll {
    val allEmployees = arrayListOf<Person>()

    fun calculatesSalary() {
        allEmployees.fold(0L) { acc, p ->
            acc + p.salary
        }
    }
}