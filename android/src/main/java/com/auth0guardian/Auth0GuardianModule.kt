package com.auth0guardian

import com.auth0.android.guardian.sdk.otp.TOTP
import android.util.Base64
import com.facebook.react.bridge.ReactApplicationContext
import com.facebook.react.bridge.ReactContextBaseJavaModule
import com.facebook.react.bridge.ReactMethod
import com.facebook.react.bridge.Promise

class Auth0GuardianModule(reactContext: ReactApplicationContext) : ReactContextBaseJavaModule(reactContext) {

  companion object {
      private const val TOTP_LENGTH = 6
      private const val TOTP_DURATION = 30
      private const val TOTP_ALGORITHM = "SHA1"
  }

  override fun getName(): String {
      return "GuardianTotp"
  }

  @ReactMethod
  fun getOTP(secret: String, promise: Promise) {
      try {
          val key = Base64.decode(secret, Base64.DEFAULT)
          val totp = TOTP(TOTP_ALGORITHM, key, TOTP_LENGTH, TOTP_DURATION)
          val otp = totp.generate()
          promise.resolve(otp)
      } catch (e: Exception) {
          promise.reject("ERROR_GENERATING_OTP", e)
      }
  }

   fun getHelloWorld(promise: Promise) {
        try {
            val message = "Hello, World!"
            promise.resolve(message)
        } catch (e: Exception) {
            promise.reject("ERROR_GETTING_MESSAGE", e)
        }
    }
}