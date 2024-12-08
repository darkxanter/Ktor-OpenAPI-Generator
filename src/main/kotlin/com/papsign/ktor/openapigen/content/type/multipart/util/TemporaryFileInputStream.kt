package com.papsign.ktor.openapigen.content.type.multipart.util

import java.io.InputStream
import java.io.OutputStream
import java.nio.file.Path
import kotlin.io.path.deleteIfExists
import kotlin.io.path.inputStream

class TemporaryFileInputStream(
    private val file: Path,
) : InputStream() {
    private val inputStream = file.inputStream()

    override fun close() {
        inputStream.close()
        file.deleteIfExists()
        super.close()
    }

    override fun read(): Int = inputStream.read()

    override fun read(b: ByteArray): Int = inputStream.read(b)

    override fun read(b: ByteArray, off: Int, len: Int): Int = inputStream.read(b, off, len)

    override fun readAllBytes(): ByteArray = inputStream.readAllBytes()

    override fun readNBytes(len: Int): ByteArray = inputStream.readNBytes(len)

    override fun readNBytes(b: ByteArray, off: Int, len: Int): Int = inputStream.readNBytes(b, off, len)

    override fun skip(n: Long): Long = inputStream.skip(n)

    override fun available(): Int = inputStream.available()

    override fun mark(readlimit: Int) {
        inputStream.mark(readlimit)
    }

    override fun reset() {
        inputStream.reset()
    }

    override fun markSupported(): Boolean {
        return inputStream.markSupported()
    }

    override fun transferTo(out: OutputStream): Long {
        return inputStream.transferTo(out)
    }
}