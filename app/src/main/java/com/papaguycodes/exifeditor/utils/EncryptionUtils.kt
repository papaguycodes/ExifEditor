package com.papaguycodes.exifeditor.utils

import javax.crypto.Cipher
import javax.crypto.KeyGenerator
import javax.crypto.SecretKey
import javax.crypto.spec.IvParameterSpec
import java.util.Base64

object EncryptionUtils {

    private const val ALGORITHM = "AES/CBC/PKCS5Padding"
    private const val KEY_SIZE = 256

    fun generateSecretKey(): SecretKey {
        val keyGen = KeyGenerator.getInstance("AES")
        keyGen.init(KEY_SIZE)
        return keyGen.generateKey()
    }

    fun encrypt(data: String, secretKey: SecretKey, iv: IvParameterSpec): String {
        val cipher = Cipher.getInstance(ALGORITHM)
        cipher.init(Cipher.ENCRYPT_MODE, secretKey, iv)
        return Base64.getEncoder().encodeToString(cipher.doFinal(data.toByteArray()))
    }

    fun decrypt(encryptedData: String, secretKey: SecretKey, iv: IvParameterSpec): String {
        val cipher = Cipher.getInstance(ALGORITHM)
        cipher.init(Cipher.DECRYPT_MODE, secretKey, iv)
        return String(cipher.doFinal(Base64.getDecoder().decode(encryptedData)))
    }

    fun generateIv(): IvParameterSpec {
        val iv = ByteArray(16)
        java.security.SecureRandom().nextBytes(iv)
        return IvParameterSpec(iv)
    }
}
