package org.ghxiao.owltoolkit;
import java.io.File;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.HashSet;
import java.util.Set;

import org.semanticweb.owlapi.apibinding.OWLManager;
import org.semanticweb.owlapi.model.AxiomType;
import org.semanticweb.owlapi.model.OWLOntology;
import org.semanticweb.owlapi.model.OWLOntologyCreationException;
import org.semanticweb.owlapi.model.parameters.Imports;
import org.semanticweb.owlapi.profiles.OWL2DLProfile;
import org.semanticweb.owlapi.profiles.OWL2ELProfile;
import org.semanticweb.owlapi.profiles.OWL2QLProfile;
import org.semanticweb.owlapi.profiles.OWL2RLProfile;
import org.semanticweb.owlapi.profiles.OWLProfile;
import org.semanticweb.owlapi.profiles.OWLProfileReport;
import org.semanticweb.owlapi.util.DLExpressivityChecker;

public class OWLDLExpressivity {

	/**
	 * @param args
	 * @throws OWLOntologyCreationException
	 */
	public static void main(String... args) throws OWLOntologyCreationException {
		boolean verbose = false;
		
		if (args.length == 0){
			System.err.println("Usage: owl-metrics [-v] file.owl");
			System.exit(0);
		}
		
		int i = 0;
		if (args[0].equals("-v") || args[0].equals("-verbos")){
			verbose = true;
			i += 1;
		}
		
		OWLOntology ontology = OWLManager.createOWLOntologyManager()
				.loadOntologyFromOntologyDocument(new File(args[i]));
		Set<OWLOntology> h = new HashSet<OWLOntology>();
		h.add(ontology);
		DLExpressivityChecker c = new DLExpressivityChecker(h);
		System.out.println("DL Expressivity:"c.getDescriptionLogicName());		
	}

}
