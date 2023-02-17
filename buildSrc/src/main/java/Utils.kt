import java.io.FileInputStream
import java.util.*

fun buildProperties(
    properties: Properties,
    onProperty: (key: String, value: String) -> Unit
) {
    val enums = properties.propertyNames() as Enumeration<String>

    while (enums.hasMoreElements()) {
        val key = enums.nextElement()
        var value = properties.getProperty(key)

        if (key.startsWith("config_")) {
            onProperty.invoke(key, value)
        }
    }
}

fun getPropertiesFileName(flavor: String, environment: String): String {
    val fileName = "properties/$flavor.$environment.properties"
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

fun applySuffix(env: String) = when (env) {
    "pre" -> ".pre"
    else -> ""
}

fun capitalize(str: String) = str[0].toUpperCase() + str.substring(1)
