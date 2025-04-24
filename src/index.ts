import { registerPlugin } from "@capacitor/core";

export interface RoundedCornersPlugin {
  getCornerRadius(): Promise<{
    cornerRadius: number;
    success: boolean;
    error?: string;
  }>;
}

const RoundedCorners = registerPlugin<RoundedCornersPlugin>("RoundedCorners");

export default RoundedCorners;
