# Minecraft Mod 1.21

Este es un mod para Minecraft 1.21 utilizando Forge 51.0.33. 

## Requisitos previos

1. [Minecraft 1.21](https://minecraft.net)
2. [Forge 51.0.33](https://files.minecraftforge.net/net/minecraftforge/forge/1.21-51.0.33/)
3. JDK 19 o superior instalado.

## Instalación

1. Clona este repositorio:
    ```bash
    git clone https://github.com/Erkoke108/MinecraftMod.git
    cd MinecraftMod
    ```

2. Asegúrate de tener [Java 19](https://www.oracle.com/java/technologies/javase/jdk19-archive-downloads.html) instalado.

3. Ejecuta el siguiente comando para descargar las dependencias de Forge:
    ```bash
    ./gradlew genEclipseRuns
    ```

4. Abre el proyecto en tu IDE preferido (por ejemplo, **Visual Studio Code**).

5. Para compilar el mod, ejecuta:
    ```bash
    ./gradlew build
    ```

6. El archivo `.jar` se generará en la carpeta `build/libs/`. Colócalo en la carpeta `mods` de tu instalación de Minecraft.

## Desarrollador

Este mod fue creado por **Erkoke108**.

Si tienes algún problema o sugerencia, abre un [issue en GitHub](https://github.com/Erkoke108/MinecraftMod/issues).

## Licencia

Este proyecto está bajo la **Licencia MIT**.
