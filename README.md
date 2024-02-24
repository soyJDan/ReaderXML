# Reader XML Library

## Introduction

The Reader library is a simple and efficient tool for reading XML files. It is written in Kotlin and can be used in any project that requires XML file parsing.

## Requirements

- Kotlin
- Java
- Gradle

## Installation

To use the Reader library in your project, you need to include it in your project's dependencies. If you're using Gradle, you can do this by adding the following line to your `build.gradle` file:

```groovy
implementation 'tech.soyjdan:reader:1.0.0'
```

## Usage

The main class in the Reader library is the `Reader` class. Here's a simple example of how to use it:

```kotlin
import soyjdan.reader.Reader
import java.io.File

fun main() {
    val reader = Reader()
    val file = File("path/to/your/xml/file.xml")
    reader.read(file)
}
```

In this example, we first create an instance of the `Reader` class. Then, we create a `File` object for the XML file we want to read. Finally, we call the `read` method on the `Reader` instance, passing the `File` object as an argument.

The `read` method will parse the XML file and print its content to the console.

## Contributing

Contributions are welcome! Please feel free to submit a pull request.

## License

The Reader library is open-source software licensed under the MIT license.