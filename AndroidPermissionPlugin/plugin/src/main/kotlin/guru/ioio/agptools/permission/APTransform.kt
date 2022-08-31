package guru.ioio.agptools.permission

import com.android.build.api.transform.QualifiedContent
import com.android.build.api.transform.Transform
import com.android.build.api.transform.TransformInvocation
import com.android.build.gradle.internal.pipeline.TransformManager

class APTransform(private val isLib: Boolean) : Transform() {

    override fun getName() = "APPlugin"

    override fun getInputTypes(): MutableSet<QualifiedContent.ContentType> = TransformManager.CONTENT_RESOURCES

    override fun getScopes(): MutableSet<in QualifiedContent.Scope> {
        return if (isLib) TransformManager.PROJECT_ONLY else TransformManager.SCOPE_FULL_PROJECT
    }

    override fun isIncremental(): Boolean {
        return false
    }

    override fun transform(transformInvocation: TransformInvocation?) {
        super.transform(transformInvocation)
        transformInvocation?.inputs?.forEach { input ->
            println("APPlugin: $input")
        }
    }
}
