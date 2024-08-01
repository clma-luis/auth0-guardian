import { NativeModules } from 'react-native';

const { Auth0GuardianModule } = NativeModules;

export const getOTP = (secret: string): Promise<string> => {
  return Auth0GuardianModule.getOTP(secret);
};

export const getHelloWorld = (): string => {
  return 'Hello World';
};
