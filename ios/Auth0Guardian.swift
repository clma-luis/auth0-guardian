import Foundation
import Guardian
import React

@objc(Auth0GuardianModule)
class Auth0GuardianModule: NSObject {

  @objc
  func getOTP(_ secret: String, resolver resolve: @escaping RCTPromiseResolveBlock, rejecter reject: @escaping RCTPromiseRejectBlock) {
    do {
      let key = Data(base64Encoded: secret)!
      let totp = TOTP(secret: key, digits: 6, timeStep: 30, algorithm: .sha1)
      let otp = totp.generate()
      resolve(otp)
    } catch let error {
      reject("ERROR_GENERATING_OTP", "Failed to generate OTP", error)
    }
  }

 @objc
  func getHelloWorld() -> String {
      return "Hello, World!"
  }
}
