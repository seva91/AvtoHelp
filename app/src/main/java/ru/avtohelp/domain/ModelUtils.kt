package ru.avtohelp.domain

fun <T> checkArg(arg: T?, predicate: (T?) -> Boolean): T? {
    require(predicate(arg))
    return arg
}

fun <T> checkNotNullArg(arg: T, predicate: (T) -> Boolean): T {
    require(predicate(arg))
    return arg
}