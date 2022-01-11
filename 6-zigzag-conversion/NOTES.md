​Better to use StringBuilder or StringBuffer instead of String if I need to use update the same String a lot, because String is immutable variable, so it will take a lot of time if it is continuously updated. However, StringBuilder and StringBuffer are mutable.
In multi-thread, choose StringBuffer and StringBuilder in the single thread situation.
