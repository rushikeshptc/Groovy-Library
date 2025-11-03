// vars/info.groovy

def call() {
    echo "=== INFO FUNCTION CALLED ==="
    echo "This is an info message from shared library!"
    echo "Function executed successfully at: ${new Date()}"
    echo "=== END INFO FUNCTION ==="
}
