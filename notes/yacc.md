## Yacc, Byacc/J

## Shift-Reduce Parsing
### Action Table

The _action table_ is a table with rows indexed by states and columns indexed by terminal symbols.
When the parse is in some state _s_ and the current lookahead terminal is _t_, the action taken
by the parser depends on the contents of _action[s][t]_, which can contain four different entries.

__Shift s'__: 
- Shift state _s'_ onto the parse stack.
- advances in the input stream by one symbol. That shifted symbol becomes a new single-node 
parse tree.

__Reduce r__: 
- Reduce by rule _r_.
- applies a completed grammar rule to some of the recent parse trees, joining them 
together as one tree with a new root symbol.

__Accept__:
- Terminate the parse with success, accepting the input.
- If we are looking at the starting non-terminal and there is no more input pending, 
you win! yyparse() returns the code that says there were no errors.

__Error__:
- Signal a parse Error
- If neither a shift nor a reduce will work, a syntax error is reported by calling 
the yyerror() function that you must write.

### Goto Table
The _goto table_ is a table with rows index by states and columns indexed by nonterminal symbols. 
When the parser is in state _s_ immediately __after__ reducing by rule _N_, then the next state 
to enter is given by _goto[s][N]_.

#### yacc parsing algo pseudocode
- __parsestk__: parse stack, array of integer finite automaton parse states.
- __index__: top tracks the subscript of the top of the parse stack
- __current__: current input symbol
- __shift_n__: means to move the input from the right to the left, pushing parse state _n_
onto the stack and moving the _current_ to the next input symbol.
- __reduce_m__: means to apply production rule _m_ by popping the number of parse states equal
to the right side of production rule _m_ and pushing the new parse state corresponding
to the non-terminal on the left side of production rule _m_. The goto table tells what
the new parse state that the _reduce_ step is to push.
```
repeat:
    x = action_table[parsestk[top], current]
    if x == shift_n then {
        push(state_n, parsestk)
        current = next
    }
    else if x == reduce_m then {
        pop(parsestk) |m| times
        push(goto_table[parsestk[top],m], parsestk)
    }
    else if x == accept then return 0 // no errors
    else { yyerror("syntax error") }
```

## Conflicts in _yacc_ parsers
Ambiguous grammars mean that there is more than one possible action that it can encode for a
given (parse state, current input) lookup in the action table. Yacc reports this as a problem
and that the generated parser will use only one of the possible interpretations of the ambiguity

- __Shift/reduce__:
    - When one production rule says it can shift the current input at this point, but another production
      rule says it is finished and ready to reduce.
    - _yacc_ will only shift if this is the case
    - Default rule is usually correct.
- __Reduce/reduce__:
    - Different product rules state to reduce. It is unknown which rule is correct.
      _yacc_ will pick the rule that appears earlier in the grammar file.
    - Cannot use default rule.
    - Parts of the grammar will never be used

