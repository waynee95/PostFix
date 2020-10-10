# PostFix Interpreter

> interpreter for the PostFix language

PostFix is a simple stack based language inspired by PostScript and Forth from the book
["Design Concepts in Programming Languages"](https://mitpress.mit.edu/books/design-concepts-programming-languages) 
by Franklyn Turbak and David Gifford.

## Examples

```
(postfix 1 4 sub)
(postfix 1 4 add 5 mul 6 sub 7 div)
```

## Build

```bash
$ ./gradlew clean build
```

## Run

```bash
$ java -jar build/libs/postfix.jar
```

## Todo

- [ ] Add error handling for commands
- [ ] Add `exec` command
