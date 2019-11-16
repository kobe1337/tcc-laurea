package model;

public class ProfessorDisciplina {
   
    private Professor professor;
    private Disciplina disciplina;

    public ProfessorDisciplina(Professor professor, Disciplina disciplina) {
        this.professor = professor;
        this.disciplina = disciplina;
    }

    public ProfessorDisciplina() {
    }

    public Professor getProfessor() {
        return professor;
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
    }

    public Disciplina getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(Disciplina disciplina) {
        this.disciplina = disciplina;
    }  
    
    @Override
    public String toString() {
        return ""+getProfessor()+" / "+getDisciplina();
    } 
    
}
