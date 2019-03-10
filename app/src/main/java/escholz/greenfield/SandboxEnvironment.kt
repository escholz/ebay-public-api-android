package escholz.greenfield

import javax.inject.Inject

class SandboxEnvironment
    @Inject
    constructor()
: Environment {
    override val name: String
        get() = "sandbox"

    override val baseSignInUrl: String
        get() = "sandbox.signin.ebay.com"
}