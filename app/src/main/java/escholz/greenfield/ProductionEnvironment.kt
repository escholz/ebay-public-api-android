package escholz.greenfield

import javax.inject.Inject

class ProductionEnvironment
    @Inject
    constructor()
: Environment {
    override val name: String
        get() = "production"

    override val baseSignInUrl: String
        get() = "signin.ebay.com"
}