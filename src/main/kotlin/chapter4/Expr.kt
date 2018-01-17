package chapter4

sealed class Expr
class Num(val value: Int) : Expr()
class Sum(val left: Expr, right: Expr)
