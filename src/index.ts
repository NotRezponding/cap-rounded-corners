import { registerPlugin } from '@capacitor/core';

export interface AndroidCornerPlugin {
  getCornerRadius(): Promise<{
    cornerRadius: number;
    success: boolean;
    error?: string;
  }>;
}

const AndroidCorner = registerPlugin<AndroidCornerPlugin>('AndroidCorner');

export default AndroidCorner;
