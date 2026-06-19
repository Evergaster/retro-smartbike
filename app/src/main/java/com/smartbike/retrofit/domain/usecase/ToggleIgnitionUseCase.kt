package com.smartbike.retrofit.domain.usecase

import com.smartbike.retrofit.domain.repository.IgnitionRepository

class ToggleIgnitionUseCase(
    private val repository: IgnitionRepository
) {
    operator fun invoke(): Boolean = repository.toggleIgnition()
}

