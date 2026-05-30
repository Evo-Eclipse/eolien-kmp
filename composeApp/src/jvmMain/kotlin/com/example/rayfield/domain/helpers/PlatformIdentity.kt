package com.example.rayfield.domain.helpers


class PlatformIdentity {
    enum class Platforms {
        Windows, MacOS, Linux, Unknown
    }

    val currentPlatform: Platforms
        get() {
            val osName = System.getProperty("os.name").lowercase()
            return when {
                osName.contains("win") -> Platforms.Windows
                osName.contains("mac") || osName.contains("darwin") -> Platforms.MacOS
                osName.contains("nix") || osName.contains("nux") || osName.contains("aix") -> Platforms.Linux
                else -> Platforms.Unknown
            }
        }
}