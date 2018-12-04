import java.io.File
import java.nio.file.Paths

object AdventUtil {

    fun getFile(pathFromSrc: String) : File {
        return File(Paths.get("src/$pathFromSrc").toAbsolutePath().toString())
    }
}