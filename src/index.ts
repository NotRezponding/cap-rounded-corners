import { registerPlugin } from "@capacitor/core";

export interface RoundedCornersPlugin {
  getCornerRadius(): Promise<{
    cornerRadius: number;  // in DP (density-independent pixels)
    cornerRadiusPx: number;  // in raw pixels
    success: boolean;
    error?: string;
  }>;
}

const RoundedCorners = registerPlugin<RoundedCornersPlugin>("RoundedCorners");

export default RoundedCorners;
