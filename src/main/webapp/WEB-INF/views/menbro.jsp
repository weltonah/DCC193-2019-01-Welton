<%@page pageEncoding="utf-8" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE HTML >
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
    <title>Menbro</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <script src="https://unpkg.com/ionicons@4.5.5/dist/ionicons.js"></script>
</head>
<body style="background-color: #f2f2f2;">
<div class="row">
    <c:import url="cabecalho.jsp" />
</div>
<div class="container mt-4 shadow p-3 mb-5 bg-white rounded" style="background-color:white; ">
    <div class="row">
        <div class="col-12">
            <div class="row justify-content-md-center">
                <div class="col-md-auto">
                    <h3> Lista de Menbros</h3>
                </div>
            </div>
        </div>
        <div class="col-12">
            <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#cadastroModal">
                <ion-icon name="add"></ion-icon>Cadastrar
            </button>
        </div>
        <div class="col-12 mt-4">

            <table class="table table-striped">
                <thead class="thead-light">
                <tr>
                    <th scope="col"></th>
                    <th scope="col"></th>
                    <th scope="col">Nome Completo</th>
                    <th scope="col">Função</th>
                    <th scope="col">E-mail de Contato</th>
                    <th scope="col">Data Inicio</th>
                    <th scope="col">Data Saída</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${listaMenbro}" var="item" varStatus="status">
                    <tr>
                        <th scope="row">
                            <a href="DeleteMenbro?idSede=${idSede}&idMenbro=${item.getId()}" class="btn btn-outline-danger btn-sm" role="button">
                                <div class="col-6"><ion-icon name="close"></ion-icon></div>
                            </a>
                        </th>
                        <th>

                            <button type="button" class="btn btn-outline-warning btn-sm" data-toggle="modal"
                                    data-target="#AlterarModal${item.getId()}">
                                <div class="col-6"><ion-icon name="create"></ion-icon></div>
                            </button>
                        </th>
                        <th>${item.getNome()}</th>
                        <th>${item.getFuncao()}</th>
                        <th>${item.getEmail()}</th>
                        <th>${item.getDataEntradaStr()}</th>
                        <th>${item.getDataSaidaStr()}</th>
                    </tr>
                    <div class="modal fade" id="AlterarModal${item.getId()}" tabindex="-1" role="dialog"
                         aria-labelledby="AlterarModal${item.getId()}Label"
                         aria-hidden="true">
                        <div class="modal-dialog" role="document">
                            <div class="modal-content">
                                <div class="modal-header">
                                    <h5 class="modal-title" id="AlterarModal${item.getId()}Label">Editar de Menbro</h5>
                                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                        <span aria-hidden="true">&times;</span>
                                    </button>
                                </div>
                                <form action="UpdateMenbro?idSede=${idSede}&idMenbro=${item.getId()}" method="post">
                                    <div class="modal-body">
                                        <div class="form-group ">
                                            <label for="AlterarnameFantasia">Nome</label>
                                            <input type="text" class="form-control form-control-sm"
                                                   id="AlterarnameFantasia"
                                                   value="${item.getNome()}"
                                                   name="nome" required>
                                        </div>
                                        <div class="form-group">
                                            <label for="Alterarcidade">Função</label>
                                            <input type="text" value="${item.getFuncao()}"
                                                   class="form-control form-control-sm" id="Alterarcidade"
                                                   name="funcao" required>
                                        </div>
                                        <div class="form-group">
                                            <label for="Alterarbairro">E-mail</label>
                                            <input type="text" value="${item.getEmail()}"
                                                   class="form-control form-control-sm" id="Alterarbairro"
                                                   name="email" required>
                                        </div>
                                        <div class="form-group">
                                            <label>Data Entrada</label>
                                            <input type="date"
                                                   value="<fmt:formatDate value="${item.getDataEntrada()}" type="date"  pattern="yyyy-MM-dd" />"
                                                   class="form-control form-control-sm"
                                                   name="dataEntrada" required>
                                        </div>
                                        <div class="form-group">
                                            <label>Data Saída</label>
                                            <input type="date"
                                                   value="<fmt:formatDate value="${item.getDataSaida()}" type="date"  pattern="yyyy-MM-dd" />"
                                                   class="form-control form-control-sm"
                                                   name="dataSaida" required>
                                        </div>
                                    </div>
                                    <div class="modal-footer">
                                        <button type="button" class="btn btn-secondary" data-dismiss="modal">Fechar
                                        </button>
                                        <button type="submit" class="btn btn-primary">Atualizar</button>
                                    </div>
                                </form>
                            </div>
                        </div>
                    </div>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>

    <!-- Button trigger modal -->


    <!-- Modal -->
    <div class="modal fade" id="cadastroModal" tabindex="-1" role="dialog" aria-labelledby="cadastroModalLabel"
         aria-hidden="true">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="cadastroModalLabel">Cadastro de Menbro</h5>
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>

                <form action="PostMenbro?idSede=${idSede}" method="post">
                    <div class="modal-body">
                        <div class="form-group ">
                            <label>Nome</label>
                            <input type="text" class="form-control form-control-sm"
                                   name="nome"  required>
                        </div>
                        <div class="form-group">
                            <label>Função</label>
                            <input type="text" class="form-control form-control-sm"
                                   name="funcao"  required>
                        </div>
                        <div class="form-group">
                            <label>E-mail</label>
                            <input type="text" class="form-control form-control-sm"
                                   name="email"  required>
                        </div>
                        <div class="form-group">
                            <label>Data Entrada</label>
                            <input type="date" class="form-control form-control-sm"
                                   name="dataEntrada" path="dataEntrada" class="date" 
                                   required>
                        </div>
                        <div class="form-group">
                            <label>Data Saída</label>
                            <input type="date" class="form-control form-control-sm"
                                   name="dataSaida"  required>
                        </div>

                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-secondary" data-dismiss="modal">Fechar</button>
                        <button type="submit" class="btn btn-primary">Salvar</button>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>
</body>
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
        integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
        crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
        integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
        crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
        integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
        crossorigin="anonymous"></script>

</html>