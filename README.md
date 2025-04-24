# Capacitor Android Corner Plugin

A Capacitor plugin to detect the rounded corner radius of Android devices.

## Installation

```bash
npm install capacitor-android-corner
npx cap sync
```

## Usage

```typescript
import AndroidCorner from 'capacitor-android-corner';

const getCornerRadius = async () => {
  const result = await AndroidCorner.getCornerRadius();
  if (result.success) {
    console.log('Corner radius:', result.cornerRadius);
  } else {
    console.error('Error:', result.error);
  }
};
```

## API

### getCornerRadius()

Returns the device's rounded corner radius in pixels.

Returns:
- `cornerRadius`: number - The corner radius in pixels
- `success`: boolean - Whether the operation was successful
- `error`: string (optional) - Error message if the operation failed

Note: On Android versions below Q (API 29), this will return 0 as the corner radius and success will be false.
