Un POJO es un objeto que no contiene ninguna interfaz ni extiende de otra clase. Es una clase sencilla y normal que solo cuenta con atributos, constructor y getters & setters.

Un Bean es otro objeto, pero con la diferencia de que este tiene varias restricciones. Su función es servir como encapsulación para varios objetos en un objeto. Un requisito que tiene para ser considerado un Bean es que debe de ser Serializable, que tiene la finalidad de almacenar el objeto en ficheros o en bases de datos. También debe de poseer un constructor vacío.

Por lo tanto, la diferencia entre estos dos es que POJO es más libre y simple, mientras que Bean es más estricto y un poco más completo.

Todos los Beans son POJOs, ya que se basan en una clase con atributos, constructores y getters & setters. Sin embargo, no todos los POJOs son Beans porque estos últimos tienen restricciones que los POJOs no tienen por qué tener necesariamente.