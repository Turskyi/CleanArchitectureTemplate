package ua.turskyi.democleanarchitecture.common.di.qualifiers

import javax.inject.Qualifier

// TODO: 8
@Qualifier
@MustBeDocumented
@Retention(AnnotationRetention.RUNTIME)
@Target(AnnotationTarget.FIELD, AnnotationTarget.FUNCTION)
annotation class ViewModelInjection {

}