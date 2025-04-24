# Capacitor Rounded Corner Plugin

A Capacitor plugin to detect the rounded corner radius of Android devices.

## Installation

```bash
npm install @notrezponding/cap-rounded-corners
npx cap sync
```

## Usage

```typescript
import RoundedCorners from "@notrezponding/cap-rounded-corners";

const getCornerRadius = async () => {
  const result = await RoundedCorners.getCornerRadius();
  if (result.success) {
    console.log("Corner radius (DP):", result.cornerRadius);
    console.log("Corner radius (Pixels):", result.cornerRadiusPx);
  } else {
    console.error("Error:", result.error);
  }
};
```

## API

### getCornerRadius()

Returns the device's rounded corner radius in both DP (density-independent pixels) and raw pixels.

Returns:
- `cornerRadius`: number - The corner radius in DP (density-independent pixels)
- `cornerRadiusPx`: number - The corner radius in raw pixels
- `success`: boolean - Whether the operation was successful
- `error`: string (optional) - Error message if the operation failed

Note: 
- On Android versions below Q (API 29), this will return 0 as the corner radius and success will be false
- The `cornerRadius` value (in DP) is what you typically want to use in your UI, as it accounts for the device's screen density
- The `cornerRadiusPx` value is the raw pixel value, which may appear larger on high-DPI screens
