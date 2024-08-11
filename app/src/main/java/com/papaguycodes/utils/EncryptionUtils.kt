package com.papaguycodes.exifeditor.utils

import android.util.Base64
import javax.crypto.Cipher
import javax.crypto.KeyGenerator
import javax.crypto.SecretKey
import javax.crypto.spec.SecretKeySpec

object EncryptionUtils {

    private const val AES = "AES"

    fun generateKey(): SecretKey {
        val keyGen = KeyGenerator.getInstance(AES)
        keyGen.init(256)
        return keyGen.generateKey()
    }

    fun encrypt(data: String, secretKey: SecretKey): String {
        val cipher = Cipher.getInstance(AES)
        cipher.init(Cipher.ENCRYPT_MODE, secretKey)
        val encryptedData = cipher.doFinal(data.toByteArray())
        return Base64.encodeToString(encryptedData, Base64.DEFAULT)
    }

    fun decrypt(encryptedData: String, secretKey: SecretKey): String {
        val cipher = Cipher.getInstance(AES)
        cipher.init(Cipher.DECRYPT_MODE, secretKey)
        val decodedData = Base64.decode(encryptedData, Base64.DEFAULT)
        return String(cipher.doFinal(decodedData))
    }

    fun secretKeyFromString(key: String): SecretKey {
        return SecretKeySpec(Base64.decode(key, Base64.DEFAULT), AES)
    }

    fun secretKeyToString(secretKey: SecretKey): String {
        return Base64.encodeToString(secretKey.encoded, Base64.DEFAULT)
    }
}
