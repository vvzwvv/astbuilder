def inputFileName = "app.groovy"
def outputFileName = "result.ast"

static def writeFile(String fileName, String fileContent) {
    def file = new File(fileName)

    if (file.exists())
        file.delete()

    def printWriter = file.newPrintWriter()

    printWriter.write(fileContent)

    printWriter.flush()
    printWriter.close()
}

def sourceCode = new File(inputFileName).text

def astResult = new org.codehaus.groovy.ast.builder.AstBuilder().buildFromString(sourceCode).toString()

writeFile(outputFileName, astResult)

