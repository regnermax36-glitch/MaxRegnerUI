# MaxRegnerUI

**High-fidelity Jetpack Compose prototype** of a futuristic cover-screen launcher, visually optimized for **Galaxy Z Flip 5** cover screen proportions.

## Design Language
- Pure black base
- Electric cyan `#00F0FF` + magenta `#FF00AA` neon accents
- Soft glassmorphism cards
- High contrast, large touch targets for small vertical screens

## Screens & Features

| Screen | Description |
|--------|-------------|
| **Home** | Status bar, weather strip, 4-column app grid, neon bottom dock |
| **App Drawer** | Searchable full app list (mock data) |
| **Lock Screen** | Large neon clock, battery ring, tap to unlock |
| **Media** | Circular album art with sweep gradient, play/pause, progress |
| **Quick Settings** | 12 interactive toggles + notification cards |
| **Settings** | Cover-screen options, behavior toggles, about |
| **Clock Faces** | Multiple clock style previews + selection |
| **Widgets** | Sample widget cards (weather, calendar, battery, steps, music) |

## Architecture
- Navigation Compose (`NavHost`)
- Clean package structure: `theme`, `screens`, `components`, `data`, `navigation`
- Mock data layer ready to be replaced with real PackageManager / MediaSession / NotificationListener

## Z Flip 5 Reality Note
True outer-display control on Galaxy Z Flip 5 requires Accessibility Service, SYSTEM_ALERT_WINDOW, QUERY_ALL_PACKAGES and Samsung-specific handling.

This project is a polished UI + navigation prototype only.

## How to build
Open in Android Studio, sync, then Build > Build APK(s).

GitHub Actions workflow is included under `.github/workflows/build.yml`.
