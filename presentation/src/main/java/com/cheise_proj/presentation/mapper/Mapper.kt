package com.cheise_proj.presentation.mapper

/***
 * Model mapper for mapping model and entity classes
 */
internal interface Mapper<T, E> {

    fun fromEntity(entity: E): T

    fun toModel(model: T): E
}

internal interface MapperList<T, E> : Mapper<T, E> {
    fun fromListEntity(entityList: List<E>): List<T>

    fun toListModel(modelList: List<T>): List<E>
}