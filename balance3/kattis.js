function calc(input) {
    const stack = [];
    for (const c of input) {
        if (["[", "("].includes(c)) stack.push(c);
        else {
            const o = stack.pop();
            if (
                o === "(" && c === ")" || 
                o === "[" && c === "]"
            ) continue;
            return 0;
        }
    }
    return Number(stack.length === 0);
}

const readline = require('readline');

const rl = readline.createInterface({
    input: process.stdin,
    output: process.stdout,
});

const lines = []

rl.once("line", line => {
    rl.on('line', line => {
        lines.push(line)
    })
    .on("close", () => {
        for (const line of lines) console.log(calc(line))
    })
})