package escholz.greenfield.dagger

import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoSet
import dagger.multibindings.Multibinds
import escholz.greenfield.Environment
import escholz.greenfield.ProductionEnvironment
import escholz.greenfield.SandboxEnvironment
import javax.inject.Singleton

@Module
abstract class EnvironmentsModule {
    @Multibinds
    @Singleton
    abstract fun multibindsEnvironments(): Set<Environment>

    @Binds
    @IntoSet
    abstract fun bindsProductionEnvironment(environment: ProductionEnvironment): Environment

    @Binds
    @IntoSet
    abstract fun bindsSandboxEnvironment(environment: SandboxEnvironment): Environment
}