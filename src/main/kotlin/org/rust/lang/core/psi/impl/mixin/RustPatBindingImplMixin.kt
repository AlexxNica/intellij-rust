package org.rust.lang.core.psi.impl.mixin

import com.intellij.lang.ASTNode
import com.intellij.psi.PsiElement
import org.rust.ide.icons.RustIcons
import org.rust.lang.core.psi.RustNamedElement
import org.rust.lang.core.psi.RustPatBindingElement
import org.rust.lang.core.psi.impl.RustNamedElementImpl
import javax.swing.Icon

abstract class RustPatBindingImplMixin(node: ASTNode) : RustNamedElementImpl(node)
                                                      , RustPatBindingElement {

    override fun getNavigationElement(): PsiElement = identifier

    override val boundElements: Collection<RustNamedElement>
        get() = listOf(this)

    override fun getIcon(flags: Int): Icon? {
        return RustIcons.BINDING
    }
}

val RustPatBindingElement.isMut: Boolean
    get() = bindingMode?.mut != null

