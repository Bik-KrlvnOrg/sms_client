package com.cheise_proj.data.mapper

/***
 * Model mapper from one object T to the other E
 */
interface Mapper<T, E> {

    fun fromObject(obj: E): T

    fun toModel(model: T): E
}

interface MapperList<T, E> : Mapper<T, E> {
    fun fromListEntity(objList: List<E>): List<T>

    fun toListModel(modelList: List<T>): List<E>
}