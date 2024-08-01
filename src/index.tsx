import { NativeModules } from 'react-native';

const { GuardianTotp } = NativeModules;

export const getOTP = (secret: string): Promise<string> => {
  return GuardianTotp.getOTP(secret);
};
