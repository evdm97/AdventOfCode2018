import java.io.File
import java.nio.file.Paths
import java.util.*
import kotlin.collections.ArrayList

object AdventUtil {

    fun getFile(pathFromSrc: String) : File {
        return File(Paths.get("src/$pathFromSrc").toAbsolutePath().toString())
    }

    fun scannerToArray(scanner: Scanner) : ArrayList<String>{
        val resultArray = ArrayList<String>()
        while (scanner.hasNext()) {
            resultArray.add(scanner.next())
        }
        return resultArray
    }

    fun getInputArray(pathFromSrc: String, delimiter: String): ArrayList<String> {
        return scannerToArray(getInputScanner(pathFromSrc, delimiter))
    }

    fun getInputScanner(pathFromSrc: String, delimiter: String) : Scanner{
        return Scanner(getFile(pathFromSrc)).useDelimiter(delimiter)
    }
    fun getInputScanner(file: File, delimiter: String) : Scanner{
        return Scanner(file).useDelimiter(delimiter)
    }
}