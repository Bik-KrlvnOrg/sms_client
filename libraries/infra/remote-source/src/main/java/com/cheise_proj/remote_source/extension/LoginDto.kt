package com.cheise_proj.remote_source.extension

import com.cheise_proj.remote_source.mapper.LoginMapper
import com.cheise_proj.remote_source.model.LoginDto

internal fun LoginDto.toModel() = LoginMapper.toModel(this)
