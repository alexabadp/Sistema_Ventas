package Entidades.Interfaces;

import java.util.List;

public interface metodosDao<T> {

    public List<T> listar();

    public boolean insertar(T obj);

    public boolean actualizar(T obj);

    public boolean eliminar(int ruc);

    public int buscarCodigo(int codigo);

    public int buscarNombre(String nombre);

    public T getObjeto(int codigo);
}
