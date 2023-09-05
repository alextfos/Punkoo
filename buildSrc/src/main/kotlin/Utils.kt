import java.io.FileInputStream
import java.util.*

fun buildProperties(
    properties: Properties,
    onProperty: (key: String, value: String) -> Unit
) {
    val enums = properties.propertyNames() as Enumeration<*>

    while (enums.hasMoreElements()) {
        val key = enums.nextElement() as? String
        val value = properties.getProperty(key)

        if (key?.startsWith("config_") == true) {
            onProperty.invoke(key, value)
        }
    }
}

fun getPropertiesFileName(flavor: String): String {
    val fileName = "properties/$flavor.properties"
    println(fileName)
    return fileName
}

fun getProperties(file: String): Properties {
    val properties = Properties()
    val inputStream = FileInputStream(file)

    properties.load(inputStream)
    inputStream.close()

    return properties
}
