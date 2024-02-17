package com.example.taller

import controller.Controller
import modelo.Dependencia
import modelo.Empresa

fun main(){

    val miEmpresa = Empresa("ArpoShop", "Las americas", 1234567890)


    val empleadosRegistrados = miEmpresa.getEmpleados()
    val clientesRegistrados = miEmpresa.getClientes()
    val controller = Controller(miEmpresa)
    val porcentajeClientesMasculinos = controller.obtenerClientesPorSexo("Masculino")
    val porcentajeClientesFemeninos = controller.obtenerClientesPorSexo("Femenino")
    val cantidadJefes = controller.obtenerEmpleadoPorCargo("Jefe")
    val cantidadProgramadores = controller.obtenerEmpleadoPorCargo("Programador")
    val cantidadAnalistas = controller.obtenerEmpleadoPorCargo("Lider")
    val empleadoAntiguo = controller.obtenerEmpleadoPorTiempo()


    println("EMPLEADOS REGISTRADOS:")

    for (empleado in empleadosRegistrados) {
        println("Nombre: ${empleado.getNombre()}")
        println("Documento: ${empleado.getDocumento()}")
        println("Correo: ${empleado.getCorreo()}")
        println("Sexo: ${empleado.getSexo()}")
        println("Cargo: ${empleado.getCargo().getNombre()}")
        println("Salario: ${empleado.getSalario()}")
        println("Año de ingreso: ${empleado.getAnioIngreso()}")
        println("Dependencia: ${empleado.getDependencia()}")
        println(" ")
    }

    println("CLIENTES REGISTRADOS:")
    for (cliente in clientesRegistrados) {
        println("Nombre: ${cliente.getNombre()}")
        println("Documento: ${cliente.getDocumento()}")
        println("Correo: ${cliente.getCorreo()}")
        println("Sexo: ${cliente.getSexo()}")
        println("Dirección: ${cliente.getDireccion()}")
        println("Teléfono: ${cliente.getTelefono()}")
        println(" ")
    }

    println("\nNOMINA TOTAL")
    val nominaTotal = controller.calcularNomina()
    println("Nómina total de la empresa: $nominaTotal")


    println("\nNOMINA POR DEPENDENCIA")

    for (dependencia in Dependencia.values()) {
        val nominaDependencia = controller.calcularNominaDependencia(dependencia)
        println("Nómina de la dependencia $dependencia: $nominaDependencia")

    }

    println("\nPORCENTAJE DE CLIENTES SEGUN SU SEXO")

    println("Porcentaje de clientes masculinos: $porcentajeClientesMasculinos%")
    println("Porcentaje de clientes femeninos: $porcentajeClientesFemeninos%")


    println("\nCANTIDAD DE EMPLEADOS SEGUN NOMBRE DE CARGO")
    println("Cantidad de empleados con cargo de JEFE: $cantidadJefes")
    println("Cantidad de empleados con cargo de PROGRAMADOR: $cantidadProgramadores")
    println("Cantidad de empleados con cargo de LIDER: $cantidadAnalistas")

    println("\nEMPLEADO MAS ANTIGUO DE: ${miEmpresa.getNombre()}")

    if (empleadoAntiguo != null) {
        println("El empleado más antiguo en la empresa es:")
        println("Nombre: ${empleadoAntiguo.getNombre()}")
        println("Año de ingreso: ${empleadoAntiguo.getAnioIngreso()}")
        println("Dependencia: ${empleadoAntiguo.getDependencia()}")
    } else {
        println("No hay empleados en la empresa.")
    }

    //Punto 1 funcion recursiva
    print("\nFUNCION RECURSIVA")

    val dividendo = 26
    val divisor = 2
    print("\nEl resultado es: "+dividirPorRestasSucesivas(dividendo, divisor))


}
fun dividirPorRestasSucesivas (dividendo: Int, divisor: Int):Int {
    if(dividendo < divisor){
        return 0;
    }
    return 1 + dividirPorRestasSucesivas(dividendo - divisor, divisor);
}