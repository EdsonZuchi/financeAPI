package io.github.edsonzuchi.FinanceAPI.shared

abstract class GenericError (
    val moduleName: String,
    val code: String,
    val description: String
){
}