object Api {

    private const val retrofitVersion = "2.9.0"
    private const val moshiVersion = "1.14.0"
    private const val arrowCoreVersion = "1.1.5"
    private const val httpLoggingInterceptorVersion = "4.10.0"
    private const val chuckerVersion = "3.5.2"
    private const val okHttpVersion = "4.10.0"

    const val retrofitConverter = "com.squareup.retrofit2:converter-moshi:$retrofitVersion"
    const val httpLoggingInterceptor =
        "com.squareup.okhttp3:logging-interceptor:$httpLoggingInterceptorVersion"
    const val retrofit = "com.squareup.retrofit2:retrofit:$retrofitVersion"
    const val moshi = "com.squareup.moshi:moshi-kotlin:$moshiVersion"
    const val moshiKapt = "com.squareup.moshi:moshi-kotlin-codegen:$moshiVersion"
    const val moshiAdapters = "com.squareup.moshi:moshi-adapters:$moshiVersion"
    const val arrowCore = "io.arrow-kt:arrow-core:$arrowCoreVersion"
    const val chucker = "com.github.chuckerteam.chucker:library:$chuckerVersion"
    const val chuckerNoOp = "com.github.chuckerteam.chucker:library-no-op:$chuckerVersion"
    const val okHttp = "com.squareup.okhttp3:okhttp:$okHttpVersion"
}
