package org.talend.designer.codegen.translators.file.output;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.core.model.metadata.IMetadataColumn;
import org.talend.core.model.process.IConnection;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.core.model.metadata.types.JavaTypesManager;
import org.talend.core.model.metadata.types.JavaType;
import org.talend.core.model.utils.NodeUtil;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

public class TFileOutputExcelBeginJava
{
  protected static String nl;
  public static synchronized TFileOutputExcelBeginJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TFileOutputExcelBeginJava result = new TFileOutputExcelBeginJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "\t\t\t\tlog.debug(\"";
  protected final String TEXT_2 = " - Retrieving records from the datasource.\");" + NL + "\t\t\t";
  protected final String TEXT_3 = NL + "\t\t\t\tlog.debug(\"";
  protected final String TEXT_4 = " - Retrieved records count: \"+ nb_line_";
  protected final String TEXT_5 = " + \" .\");" + NL + "\t\t\t";
  protected final String TEXT_6 = " - Retrieved records count: \"+ globalMap.get(\"";
  protected final String TEXT_7 = "_NB_LINE\") + \" .\");" + NL + "\t\t\t";
  protected final String TEXT_8 = " - Written records count: \" + nb_line_";
  protected final String TEXT_9 = NL + "\t\t\t\tfinal StringBuffer log4jSb_";
  protected final String TEXT_10 = " = new StringBuffer();" + NL + "\t\t\t";
  protected final String TEXT_11 = " - Retrieving the record \" + (nb_line_";
  protected final String TEXT_12 = ") + \".\");" + NL + "\t\t\t";
  protected final String TEXT_13 = " - Writing the record \" + nb_line_";
  protected final String TEXT_14 = " + \" to the file.\");" + NL + "\t\t\t";
  protected final String TEXT_15 = " - Processing the record \" + nb_line_";
  protected final String TEXT_16 = " + \".\");" + NL + "\t\t\t";
  protected final String TEXT_17 = " - Processed records count: \" + nb_line_";
  protected final String TEXT_18 = NL;
  protected final String TEXT_19 = " " + NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_20 = " = routines.system.PasswordEncryptUtil.decryptPassword(";
  protected final String TEXT_21 = ");";
  protected final String TEXT_22 = NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_23 = " = ";
  protected final String TEXT_24 = "; ";
  protected final String TEXT_25 = NL + "        String password_";
  protected final String TEXT_26 = " = decryptedPassword_";
  protected final String TEXT_27 = ";";
  protected final String TEXT_28 = NL + "\t\t\tclass ExcelDynamicUtil_";
  protected final String TEXT_29 = "{" + NL + "\t\t\t\tint dynamicColCount=0;" + NL + "\t\t\t\tprivate java.util.List<String> numberTypes = java.util.Arrays.asList(" + NL + "\t\t\t\t\tnew String[]{\"Integer\", \"Float\", \"Double\", \"Long\", \"Short\", \"Byte\", \"BigDecimal\"});" + NL + "\t\t\t\t" + NL + "\t\t\t\tpublic boolean isNumberType(String talendType){" + NL + "\t\t\t\t\tif(talendType==null){" + NL + "\t\t\t\t\t\treturn false;" + NL + "\t\t\t\t\t}else{" + NL + "\t\t\t\t\t\treturn numberTypes.contains(talendType.replaceAll(\"id_\",\"\"));" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t}" + NL + "\t\t\t";
  protected final String TEXT_30 = NL + "\t\t\t\tint[] fitWidth;" + NL + "\t\t\t\tjxl.write.WritableCellFormat cellFormat;" + NL + "\t\t\t\tjxl.write.WritableCellFormat dateCellFormat;" + NL + "\t\t\t\t" + NL + "\t\t\t\tpublic ExcelDynamicUtil_";
  protected final String TEXT_31 = "(){" + NL + "\t\t\t\t\tinitFormat();" + NL + "\t\t\t\t}" + NL + "\t\t\t\tpublic void initFormat(){" + NL + "\t\t\t\t\t";
  protected final String TEXT_32 = NL + "\t\t\t\t\t\tjxl.write.WritableFont font = new jxl.write.WritableFont(jxl.write.WritableFont.";
  protected final String TEXT_33 = ", 10, jxl.write.WritableFont.NO_BOLD, false);" + NL + "\t\t        \t\tcellFormat  = new jxl.write.WritableCellFormat(font); " + NL + "\t\t        \t\tdateCellFormat=new jxl.write.WritableCellFormat(font ,new jxl.write.DateFormat(";
  protected final String TEXT_34 = "));" + NL + "\t\t\t\t\t";
  protected final String TEXT_35 = NL + "\t\t\t\t\t\tdateCellFormat=new jxl.write.WritableCellFormat(new jxl.write.DateFormat(";
  protected final String TEXT_36 = NL + "\t\t\t\t}" + NL + "\t\t\t\t" + NL + "\t\t\t\tpublic String getJxlWriteType(DynamicMetadata dynamicColumn){" + NL + "\t\t\t\t\tString talendType=dynamicColumn.getType();" + NL + "\t\t\t\t\tString jxlWriteType=\"Number\";" + NL + "    \t\t\t\tboolean isNumber = false;" + NL + "\t\t\t\t\tif(\"id_Boolean\".equals(talendType)){" + NL + "\t\t\t\t\t\tjxlWriteType=\"Boolean\";" + NL + "\t\t\t\t\t}else if(\"id_Date\".equals(talendType)){" + NL + "\t\t\t\t\t\tjxlWriteType=\"DateTime\";" + NL + "\t\t\t\t    }else if(\"id_String\".equals(talendType)||" + NL + "\t\t\t\t    \t\t \"id_Character\".equals(talendType)||" + NL + "\t\t\t\t    \t\t \"id_byte[]\".equals(talendType)||" + NL + "\t\t\t\t    \t\t \"id_List\".equals(talendType)||" + NL + "\t\t\t\t    \t\t \"id_Object\".equals(talendType)||" + NL + "\t\t\t\t    \t\t (";
  protected final String TEXT_37 = " && isNumberType(talendType))" + NL + "\t\t\t\t    \t\t ){" + NL + "\t\t\t\t    \tjxlWriteType=\"Label\";" + NL + "\t\t\t\t\t}else{" + NL + "\t\t\t\t\t\tjxlWriteType=\"Number\";" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t\treturn jxlWriteType;" + NL + "\t\t\t\t}" + NL + "\t\t\t\t";
  protected final String TEXT_38 = NL + "\t\t\t\t\tpublic int writeHeaderToExcelFile(jxl.write.WritableSheet writableSheet,int columnIndex,int rowNum,";
  protected final String TEXT_39 = "Struct row,int [] currentFitWidths)" + NL + "\t\t\t\t\t\tthrows jxl.write.biff.RowsExceededException, jxl.write.WriteException{" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_40 = NL + "\t\t\t\t\t\t\tif (rowNum == ";
  protected final String TEXT_41 = "){" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_42 = NL + "\t\t\t\t\t\t\tif (rowNum == 0){" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_43 = NL + "\t\t\t\t\t\tjxl.write.WritableCell cell  = null;" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_44 = NL + "\t\t\t\t\t        \tdynamicColCount = row.";
  protected final String TEXT_45 = ".getColumnCount();" + NL + "\t\t\t\t\t\t        for (int i = 0; i < dynamicColCount; i++) {" + NL + "\t\t\t\t\t\t\t\t\tDynamicMetadata dynamicColumn = row.";
  protected final String TEXT_46 = ".getColumnMetadata(i);" + NL + "\t\t\t\t\t\t\t\t\tif (dynamicColumn.getName() != null) {" + NL + "\t\t\t\t\t\t\t\t\t\tcell  = new jxl.write.Label(columnIndex+i+";
  protected final String TEXT_47 = ", rowNum, dynamicColumn.getName()";
  protected final String TEXT_48 = ",cellFormat";
  protected final String TEXT_49 = ");" + NL + "\t\t\t\t\t\t\t\t\t\twritableSheet.addCell(cell);" + NL + "\t\t\t\t\t\t\t\t\t\twritableSheet.setColumnView(columnIndex+i+";
  protected final String TEXT_50 = ", dynamicColumn.getName().trim().length());" + NL + "\t\t\t\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\t\t\t" + NL + "\t\t\t\t\t        ";
  protected final String TEXT_51 = NL + "\t\t\t\t\t      \t\t" + NL + "\t\t\t\t\t\t\t\tcell  = new jxl.write.Label(columnIndex+";
  protected final String TEXT_52 = "+dynamicColCount-1";
  protected final String TEXT_53 = ", rowNum, \"";
  protected final String TEXT_54 = "\"";
  protected final String TEXT_55 = ");" + NL + "\t\t\t\t\t\t\t\twritableSheet.addCell(cell);" + NL + "\t\t\t\t\t\t\t\twritableSheet.setColumnView(columnIndex+";
  protected final String TEXT_56 = ", \"";
  protected final String TEXT_57 = "\".length());" + NL + "\t\t\t\t\t\t\t\tif(\"";
  protected final String TEXT_58 = "\".length() > currentFitWidths[";
  protected final String TEXT_59 = "]){" + NL + "\t\t\t\t\t\t\t\t\tcurrentFitWidths[";
  protected final String TEXT_60 = "] = \"";
  protected final String TEXT_61 = "\".length();" + NL + "\t\t\t\t\t\t\t\t}" + NL + "\t\t\t\t\t        ";
  protected final String TEXT_62 = NL + "\t\t\t\t\t\t\treturn 1;" + NL + "\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\treturn 0;" + NL + "\t\t\t\t" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t";
  protected final String TEXT_63 = NL + "\t\t\t\tpublic void writeValuesToExcelFile(Dynamic column, jxl.write.WritableSheet writableSheet,int columnIndex,int rowNum)" + NL + "\t\t\t\t\tthrows jxl.write.biff.RowsExceededException, jxl.write.WriteException{" + NL + "\t\t\t\t\tdynamicColCount = column.getColumnCount();" + NL + "\t\t\t\t\tif(fitWidth == null){" + NL + "\t\t\t\t\t\tfitWidth = new int[dynamicColCount];" + NL + "\t\t\t\t\t\tfor(int i=0;i<dynamicColCount;i++){" + NL + "\t\t\t\t\t\t    int fitCellViewSize=writableSheet.getColumnView(i+";
  protected final String TEXT_64 = "+";
  protected final String TEXT_65 = ").getSize();" + NL + "\t\t\t\t\t\t\tfitWidth[i]=fitCellViewSize/256;" + NL + "\t\t\t\t\t\t\tif(fitCellViewSize%256!=0){" + NL + "\t\t\t\t\t\t\t\tfitWidth[i]+=1;" + NL + "\t\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\t}" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t\tfor (int i = 0; i < dynamicColCount; i++) {" + NL + "\t\t\t\t\t\tif (column.getColumnValue(i) != null) {" + NL + "\t\t\t\t\t\t\tDynamicMetadata dynamicColumn = column.getColumnMetadata(i);" + NL + "\t\t\t\t\t\t\tString jxlWriteType = getJxlWriteType(dynamicColumn);" + NL + "\t\t\t                jxl.write.WritableCell cell = null;" + NL + "\t\t\t                if(\"Boolean\".equals(jxlWriteType)){" + NL + "\t\t\t                \tcell = new jxl.write.Boolean(columnIndex+i, rowNum, ((Boolean)column.getColumnValue(i))";
  protected final String TEXT_66 = ");" + NL + "\t\t\t                }else if(\"Label\".equals(jxlWriteType)){" + NL + "\t\t\t                \tif(";
  protected final String TEXT_67 = " && isNumberType(dynamicColumn.getType())) { " + NL + "\t\t\t                \t\tcell = new jxl.write.Label(columnIndex+i, rowNum, FormatterUtils.format_Number(String.valueOf(column.getColumnValue(i)), ";
  protected final String TEXT_68 = ", ";
  protected final String TEXT_69 = ")";
  protected final String TEXT_70 = ");" + NL + "\t\t\t                \t}else{" + NL + "\t\t\t                \t\tcell = new jxl.write.Label(columnIndex+i, rowNum, column.getColumnValue(i).toString()";
  protected final String TEXT_71 = ");" + NL + "\t\t\t                \t}" + NL + "\t\t\t                }else if(\"DateTime\".equals(jxlWriteType)){" + NL + "\t\t\t                \tcell = new jxl.write.DateTime(columnIndex+i, rowNum, ((java.util.Date)column.getColumnValue(i)), dateCellFormat);" + NL + "\t\t\t                }else{" + NL + "\t\t\t                \tcell = new jxl.write.Number(columnIndex+i, rowNum, Double.valueOf(column.getColumnValue(i).toString())";
  protected final String TEXT_72 = ");" + NL + "\t\t\t                }" + NL + "\t\t\t                writableSheet.addCell(cell);" + NL + "\t\t\t                " + NL + "\t\t\t                int currentWith = 5;" + NL + "\t\t\t                if(\"Number\".equals(jxlWriteType)){" + NL + "\t\t\t\t\t\t\t\tcurrentWith = String.valueOf(((jxl.write.Number)cell).getValue()).trim().length();" + NL + "\t\t\t\t\t\t\t\tcurrentWith=currentWith>10?10:currentWith;" + NL + "\t\t\t\t\t\t\t}else if(!\"Boolean\".equals(jxlWriteType)){" + NL + "\t\t\t\t\t\t\t\tcurrentWith = cell.getContents().trim().length();" + NL + "\t\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\t\tfitWidth[i] = fitWidth[i] > currentWith ? fitWidth[i]:currentWith+2;" + NL + "\t\t\t            }" + NL + "\t\t\t        }" + NL + "\t\t\t\t}" + NL + "\t\t\t\tpublic void autoDynamicColumnSize(jxl.write.WritableSheet writableSheet,int columnIndex){" + NL + "\t\t\t\t\tfor (int i = 0; i < dynamicColCount; i++) {" + NL + "\t\t\t\t\t\twritableSheet.setColumnView(columnIndex+i, fitWidth[i]);" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t}" + NL + "\t\t\t";
  protected final String TEXT_73 = NL + "\t\t\t" + NL + "\t\t\t\t";
  protected final String TEXT_74 = NL + "\t\t\t\t\tpublic int writeHeaderToExcelFile(";
  protected final String TEXT_75 = "Struct row, org.talend.ExcelTool xlsxTool,int nbLine){" + NL + "\t\t\t\t\t\tif(nbLine < 1){" + NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_76 = NL + "\t\t\t\t\t\t\t\tif (xlsxTool.getStartRow() == 0){" + NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_77 = NL + "\t\t\t\t\t\t\t\txlsxTool.addRow();" + NL + "\t\t\t\t\t\t\t\t";
  protected final String TEXT_78 = NL + "\t\t\t\t\t\t\t\t\t\tdynamicColCount = row.";
  protected final String TEXT_79 = ".getColumnCount();" + NL + "\t\t\t\t\t\t\t\t        for (int i = 0; i < dynamicColCount; i++) {" + NL + "\t\t\t\t\t\t\t\t\t\t\tDynamicMetadata dynamicColumn = row.";
  protected final String TEXT_80 = ".getColumnMetadata(i);" + NL + "\t\t\t\t\t\t\t\t\t\t\tif (dynamicColumn.getName() != null) {" + NL + "\t\t\t\t\t\t\t\t\t\t\t\txlsxTool.addCellValue(dynamicColumn.getName());" + NL + "\t\t\t\t\t\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_81 = NL + "\t\t\t\t\t\t\t\t\t\txlsxTool.addCellValue(\"";
  protected final String TEXT_82 = "\");" + NL + "\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_83 = NL + "\t\t\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_84 = NL + "\t\t\t\t\t\t\treturn 1;" + NL + "\t\t\t\t\t\t}else{" + NL + "\t\t\t\t\t\t\treturn 0;" + NL + "\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\t" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t";
  protected final String TEXT_85 = NL + "\t\t\t\tpublic void writeValuesToExcelFile(Dynamic column, org.talend.ExcelTool xlsxTool){" + NL + "\t\t\t\t\tdynamicColCount = column.getColumnCount();" + NL + "\t\t\t\t\tfor (int i = 0; i < dynamicColCount; i++) {" + NL + "\t\t\t\t\t\tif (column.getColumnValue(i) != null) {" + NL + "\t\t\t\t\t\t\tDynamicMetadata dynamicColumn = column.getColumnMetadata(i);" + NL + "\t\t\t\t\t\t\tString talendType=dynamicColumn.getType();" + NL + "\t\t\t                if(\"id_Date\".equals(talendType)){" + NL + "\t\t\t                \txlsxTool.addCellValue((java.util.Date)column.getColumnValue(i), ";
  protected final String TEXT_86 = ");" + NL + "\t\t\t                } else if(";
  protected final String TEXT_87 = " && isNumberType(talendType)) { " + NL + "\t\t\t\t\t\t\t\txlsxTool.addCellValue(FormatterUtils.format_Number(String.valueOf(column.getColumnValue(i)), ";
  protected final String TEXT_88 = "));" + NL + "\t\t\t                } else if(isNumberType(talendType)) { " + NL + "\t\t\t                \txlsxTool.addCellValue(Double.parseDouble(String.valueOf(column.getColumnValue(i))));" + NL + "\t\t\t                }else if(\"id_Boolean\".equals(talendType)){" + NL + "\t\t\t                \txlsxTool.addCellValue((Boolean)(column.getColumnValue(i)));" + NL + "\t\t\t                }else{" + NL + "\t\t\t                \txlsxTool.addCellValue(String.valueOf(column.getColumnValue(i)));" + NL + "\t\t\t                }" + NL + "\t\t\t            }else{" + NL + "\t\t\t            \txlsxTool.addCellNullValue();" + NL + "\t\t\t            }" + NL + "\t\t\t        }" + NL + "\t\t\t\t}" + NL + "\t\t\t\tpublic void autoDynamicColumnSize(org.talend.ExcelTool xlsxTool){" + NL + "\t\t\t\t\tfor (int i = 0; i < dynamicColCount; i++) {" + NL + "\t\t\t\t\t\txlsxTool.setColAutoSize(i+";
  protected final String TEXT_89 = ");" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t}" + NL + "\t\t\t";
  protected final String TEXT_90 = NL + "\t\t\t\tpublic int getDynamicColCount(){" + NL + "\t\t\t\t\treturn dynamicColCount;" + NL + "\t\t\t\t}" + NL + "\t\t\t}" + NL + "\t\t\tExcelDynamicUtil_";
  protected final String TEXT_91 = " excelDynamicUtil_";
  protected final String TEXT_92 = "=new ExcelDynamicUtil_";
  protected final String TEXT_93 = "();" + NL + "\t\t\t";
  protected final String TEXT_94 = NL + "\t\tint columnIndex_";
  protected final String TEXT_95 = " = 0;" + NL + "\t\t";
  protected final String TEXT_96 = NL + "\t\tint nb_line_";
  protected final String TEXT_97 = " = 0;" + NL;
  protected final String TEXT_98 = "\t\t" + NL + "\t\tString fileName_";
  protected final String TEXT_99 = "=";
  protected final String TEXT_100 = ";" + NL + "\t\tjava.io.File file_";
  protected final String TEXT_101 = " = new java.io.File(fileName_";
  protected final String TEXT_102 = ");" + NL + "\t\tboolean isFileGenerated_";
  protected final String TEXT_103 = " = true;";
  protected final String TEXT_104 = NL + "\t\tif(file_";
  protected final String TEXT_105 = ".exists()){" + NL + "\t\t\tisFileGenerated_";
  protected final String TEXT_106 = " = false;" + NL + "\t\t}";
  protected final String TEXT_107 = NL + "//create directory only if not exists\t\t  " + NL + "          java.io.File parentFile_";
  protected final String TEXT_108 = " = file_";
  protected final String TEXT_109 = ".getParentFile();" + NL + "          if (parentFile_";
  protected final String TEXT_110 = " != null && !parentFile_";
  protected final String TEXT_111 = ".exists()) {" + NL + "        \t";
  protected final String TEXT_112 = NL + "\t\t\t\tlog.info(\"";
  protected final String TEXT_113 = " - Creating directory '\" +parentFile_";
  protected final String TEXT_114 = ".getCanonicalPath() + \"'.\");" + NL + "\t\t\t";
  protected final String TEXT_115 = NL + "             parentFile_";
  protected final String TEXT_116 = ".mkdirs();" + NL + "        \t";
  protected final String TEXT_117 = " - Create directory '\"+parentFile_";
  protected final String TEXT_118 = ".getCanonicalPath()+\"' has succeeded.\");" + NL + "\t\t\t";
  protected final String TEXT_119 = NL + "          }";
  protected final String TEXT_120 = "\t\t" + NL + "\t\t" + NL + "\t\tjxl.write.WritableWorkbook writeableWorkbook_";
  protected final String TEXT_121 = " = null;" + NL + "\t\tjxl.write.WritableSheet writableSheet_";
  protected final String TEXT_122 = " = null;" + NL + "\t\t" + NL + "\t\tjxl.WorkbookSettings workbookSettings_";
  protected final String TEXT_123 = " = new jxl.WorkbookSettings();" + NL + "        workbookSettings_";
  protected final String TEXT_124 = ".setEncoding(";
  protected final String TEXT_125 = NL + "\t\twriteableWorkbook_";
  protected final String TEXT_126 = " = new jxl.write.biff.WritableWorkbookImpl(" + NL + "            \t\tnew java.io.BufferedOutputStream(";
  protected final String TEXT_127 = "), " + NL + "            \t\tfalse, workbookSettings_";
  protected final String TEXT_128 = "  " + NL + "        if (file_";
  protected final String TEXT_129 = ".exists()) {" + NL + "        jxl.Workbook workbook_";
  protected final String TEXT_130 = " = jxl.Workbook.getWorkbook(file_";
  protected final String TEXT_131 = ",workbookSettings_";
  protected final String TEXT_132 = ");" + NL + "        workbookSettings_";
  protected final String TEXT_133 = ".setWriteAccess(null);" + NL + "        writeableWorkbook_";
  protected final String TEXT_134 = " = new jxl.write.biff.WritableWorkbookImpl(" + NL + "                \tnew java.io.BufferedOutputStream(new java.io.FileOutputStream(file_";
  protected final String TEXT_135 = ", false)), " + NL + "                \tworkbook_";
  protected final String TEXT_136 = ", " + NL + "                \ttrue," + NL + "                    workbookSettings_";
  protected final String TEXT_137 = ");" + NL + "        }else{        " + NL + "\t\twriteableWorkbook_";
  protected final String TEXT_138 = " = new jxl.write.biff.WritableWorkbookImpl(" + NL + "            \t\tnew java.io.BufferedOutputStream(new java.io.FileOutputStream(fileName_";
  protected final String TEXT_139 = ")), " + NL + "            \t\ttrue, " + NL + "            \t\tworkbookSettings_";
  protected final String TEXT_140 = ");        " + NL + "        }     ";
  protected final String TEXT_141 = NL + NL + "        writableSheet_";
  protected final String TEXT_142 = " = writeableWorkbook_";
  protected final String TEXT_143 = ".getSheet(";
  protected final String TEXT_144 = ");" + NL + "        if(writableSheet_";
  protected final String TEXT_145 = " == null){" + NL + "        \twritableSheet_";
  protected final String TEXT_146 = ".createSheet(";
  protected final String TEXT_147 = ", writeableWorkbook_";
  protected final String TEXT_148 = ".getNumberOfSheets());" + NL + "\t\t}" + NL;
  protected final String TEXT_149 = NL + "        else {" + NL + "" + NL + "            String[] sheetNames_";
  protected final String TEXT_150 = ".getSheetNames();" + NL + "            for (int i = 0; i < sheetNames_";
  protected final String TEXT_151 = ".length; i++) {" + NL + "                if (sheetNames_";
  protected final String TEXT_152 = "[i].equals(";
  protected final String TEXT_153 = ")) {" + NL + "                    writeableWorkbook_";
  protected final String TEXT_154 = ".removeSheet(i);" + NL + "                    break;" + NL + "                }" + NL + "            }" + NL + "" + NL + "\t\t\twritableSheet_";
  protected final String TEXT_155 = ".getNumberOfSheets());" + NL + "        }";
  protected final String TEXT_156 = NL + NL + "        //modif start";
  protected final String TEXT_157 = NL + "\t\tint startRowNum_";
  protected final String TEXT_158 = NL + "        int startRowNum_";
  protected final String TEXT_159 = " = writableSheet_";
  protected final String TEXT_160 = ".getRows();";
  protected final String TEXT_161 = NL + "\t\t//modif end" + NL + "\t\t" + NL + "\t\tint[] fitWidth_";
  protected final String TEXT_162 = " = new int[";
  protected final String TEXT_163 = "];" + NL + "\t\tfor(int i_";
  protected final String TEXT_164 = "=0;i_";
  protected final String TEXT_165 = "<";
  protected final String TEXT_166 = ";i_";
  protected final String TEXT_167 = "++){" + NL + "\t\t    int fitCellViewSize_";
  protected final String TEXT_168 = "=writableSheet_";
  protected final String TEXT_169 = ".getColumnView(i_";
  protected final String TEXT_170 = ").getSize();" + NL + "\t\t\tfitWidth_";
  protected final String TEXT_171 = "[i_";
  protected final String TEXT_172 = "]=fitCellViewSize_";
  protected final String TEXT_173 = "/256;" + NL + "\t\t\tif(fitCellViewSize_";
  protected final String TEXT_174 = "%256!=0){" + NL + "\t\t\t\tfitWidth_";
  protected final String TEXT_175 = "]+=1;" + NL + "\t\t\t}" + NL + "\t\t}";
  protected final String TEXT_176 = NL + "\t\t" + NL + "\t\tjxl.write.WritableFont wf_";
  protected final String TEXT_177 = " = new jxl.write.WritableFont(jxl.write.WritableFont.";
  protected final String TEXT_178 = ", 10, jxl.write.WritableFont.NO_BOLD, false);" + NL + "        jxl.write.WritableCellFormat format_";
  protected final String TEXT_179 = "  = new jxl.write.WritableCellFormat(wf_";
  protected final String TEXT_180 = "); ";
  protected final String TEXT_181 = NL;
  protected final String TEXT_182 = NL + "    \t\t\t\t\tfinal jxl.write.WritableCellFormat cell_format_";
  protected final String TEXT_183 = "_";
  protected final String TEXT_184 = "=new jxl.write.WritableCellFormat(wf_";
  protected final String TEXT_185 = " ,new jxl.write.DateFormat(";
  protected final String TEXT_186 = "));";
  protected final String TEXT_187 = "\t\t\t\t\t" + NL + "\t\t\t\t\t\tfinal jxl.write.WritableCellFormat cell_format_";
  protected final String TEXT_188 = "=new jxl.write.WritableCellFormat(new jxl.write.DateFormat(";
  protected final String TEXT_189 = NL + "\t\tif(true){" + NL + "\t\t\tthrow new RuntimeException(\"Date pattern must be set for column ";
  protected final String TEXT_190 = " in the schema of component ";
  protected final String TEXT_191 = "! \");" + NL + "\t\t}";
  protected final String TEXT_192 = "\t\t" + NL;
  protected final String TEXT_193 = NL + "\t\tclass FileOutputExcelUtil_";
  protected final String TEXT_194 = "{";
  protected final String TEXT_195 = NL + "\t\t\tExcelDynamicUtil_";
  protected final String TEXT_196 = "();";
  protected final String TEXT_197 = NL + "\t\t\tpublic void putHeaderValue_";
  protected final String TEXT_198 = "(final jxl.write.WritableSheet writableSheet_";
  protected final String TEXT_199 = ",final int rowNum_";
  protected final String TEXT_200 = "," + NL + "\t\t\t\tfinal jxl.write.WritableCellFormat format_";
  protected final String TEXT_201 = ",final int[] fitWidth_";
  protected final String TEXT_202 = ") throws java.lang.Exception {";
  protected final String TEXT_203 = NL + "\t\t\twritableSheet_";
  protected final String TEXT_204 = ".addCell(new jxl.write.Label(";
  protected final String TEXT_205 = " + ";
  protected final String TEXT_206 = ", rowNum_";
  protected final String TEXT_207 = NL + "\t\t\t\t\t,format_";
  protected final String TEXT_208 = NL + "\t\t\t));\t\t";
  protected final String TEXT_209 = NL + "\t\t\t));";
  protected final String TEXT_210 = NL + "        \t\t//modif end" + NL + "    \t\tfitWidth_";
  protected final String TEXT_211 = "[";
  protected final String TEXT_212 = "]=fitWidth_";
  protected final String TEXT_213 = "]>";
  protected final String TEXT_214 = "?fitWidth_";
  protected final String TEXT_215 = "]:";
  protected final String TEXT_216 = NL + "\t\t\t}";
  protected final String TEXT_217 = NL + "\t\t\tpublic void setColumnView_";
  protected final String TEXT_218 = "," + NL + "\t\t\t\tfinal int[] fitWidth_";
  protected final String TEXT_219 = ") throws java.lang.Exception {" + NL + "\t\t\t\t\tint columnIndex_";
  protected final String TEXT_220 = " = 0;";
  protected final String TEXT_221 = NL + "\t\t\t\t\tcolumnIndex_";
  protected final String TEXT_222 = " = excelDynamicUtil_";
  protected final String TEXT_223 = ".getDynamicColCount()+";
  protected final String TEXT_224 = ";" + NL + "\t\t\t\t";
  protected final String TEXT_225 = NL + "    \t\t\t//modif start" + NL + "        \t\t";
  protected final String TEXT_226 = NL + "        \t\t\twritableSheet_";
  protected final String TEXT_227 = ".setColumnView(columnIndex_";
  protected final String TEXT_228 = "  + ";
  protected final String TEXT_229 = ", fitWidth_";
  protected final String TEXT_230 = "]);" + NL + "        \t\t";
  protected final String TEXT_231 = " , fitWidth_";
  protected final String TEXT_232 = NL + "    \t\t\t//modif end";
  protected final String TEXT_233 = NL + "\t\t\t\t\t\t\tcolumnIndex_";
  protected final String TEXT_234 = ";" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_235 = "]);";
  protected final String TEXT_236 = NL + "\t\t\tpublic void putValue_";
  protected final String TEXT_237 = "(final ";
  protected final String TEXT_238 = "Struct ";
  protected final String TEXT_239 = "," + NL + "\t\t\t\tfinal jxl.write.WritableSheet writableSheet_";
  protected final String TEXT_240 = ",final int startRowNum_";
  protected final String TEXT_241 = ",final int nb_line_";
  protected final String TEXT_242 = ",int[] fitWidth_";
  protected final String TEXT_243 = ") throws java.lang.Exception {" + NL + "\t\t\t\tint columnIndex_";
  protected final String TEXT_244 = NL + "\t\t\t";
  protected final String TEXT_245 = "\t\t\t\t";
  protected final String TEXT_246 = "   \t\t\t\t" + NL + "\t    \t\t\t\tif(";
  protected final String TEXT_247 = ".";
  protected final String TEXT_248 = " != null) {" + NL + "    \t\t\t\t";
  protected final String TEXT_249 = NL + "\t\t\t\t\t" + NL + "//modif start" + NL + "\t\t\t\t\t";
  protected final String TEXT_250 = NL + "\t\t\t\t\t\tcolumnIndex_";
  protected final String TEXT_251 = ";" + NL + "\t\t\t\t\t";
  protected final String TEXT_252 = NL + NL + "\t\t\t\t\t";
  protected final String TEXT_253 = NL + "\t\t\t\t\t\t";
  protected final String TEXT_254 = NL + "\t\t\t\t\t\t\tjxl.write.WritableCell existingCell_";
  protected final String TEXT_255 = ".getWritableCell(columnIndex_";
  protected final String TEXT_256 = ", startRowNum_";
  protected final String TEXT_257 = " + nb_line_";
  protected final String TEXT_258 = ") ;" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_259 = NL + "\t\t\t\t\t\tjxl.write.WritableCell cell_";
  protected final String TEXT_260 = " = new jxl.write.";
  protected final String TEXT_261 = "(columnIndex_";
  protected final String TEXT_262 = " ," + NL + "\t\t\t\t\t";
  protected final String TEXT_263 = "," + NL + "\t\t\t\t\t";
  protected final String TEXT_264 = NL + "//modif end";
  protected final String TEXT_265 = NL + "\t\t\t\t\t\t\t\t";
  protected final String TEXT_266 = ", cell_format_";
  protected final String TEXT_267 = NL + "\t\t\t\t\t\t\tString.valueOf(";
  protected final String TEXT_268 = "\t\t\t\t\t" + NL + "\t\t\t\t\t\t\t\t";
  protected final String TEXT_269 = ".toString()";
  protected final String TEXT_270 = "\t\t\t\t\t" + NL + "\t\t\t\t\t\t\t\tjava.nio.charset.Charset.defaultCharset().decode(java.nio.ByteBuffer.wrap(";
  protected final String TEXT_271 = ")).toString()";
  protected final String TEXT_272 = NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_273 = NL + "\t\t\t\t\t\t\tFormatterUtils.format_Number(String.valueOf(";
  protected final String TEXT_274 = "), ";
  protected final String TEXT_275 = ")\t\t\t\t" + NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_276 = "\t\t" + NL + "\t\t\t\t\t\t\t(";
  protected final String TEXT_277 = ").doubleValue()";
  protected final String TEXT_278 = NL + "\t\t\t\t\t\t,format_";
  protected final String TEXT_279 = NL + "\t\t\t\t\t\t\t);" + NL + "//modif start\t\t\t\t\t" + NL + "\t\t\t\t\t\t\t//If we keep the cell format from the existing cell in sheet" + NL + "\t\t\t\t\t\t\t" + NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_280 = NL + "\t\t\t\t\t\t\t\tif(existingCell_";
  protected final String TEXT_281 = ".getCellFormat()!=null)" + NL + "\t\t\t\t\t\t\t\t\tcell_";
  protected final String TEXT_282 = ".setCellFormat( existingCell_";
  protected final String TEXT_283 = ".getCellFormat());" + NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_284 = NL + "//modif ends\t\t\t\t\t\t\t" + NL + "\t\t\t\t\t\t\twritableSheet_";
  protected final String TEXT_285 = ".addCell(cell_";
  protected final String TEXT_286 = NL + "\t\t\t\t\t\t\tint currentWith_";
  protected final String TEXT_287 = " = String.valueOf(((jxl.write.Number)cell_";
  protected final String TEXT_288 = ").getValue()).trim().length();" + NL + "\t\t\t\t\t\t\tcurrentWith_";
  protected final String TEXT_289 = "=currentWith_";
  protected final String TEXT_290 = ">10?10:currentWith_";
  protected final String TEXT_291 = " = cell_";
  protected final String TEXT_292 = ".getContents().trim().length();";
  protected final String TEXT_293 = NL + "\t\t\t\t\t\t\tfitWidth_";
  protected final String TEXT_294 = "]>currentWith_";
  protected final String TEXT_295 = "]:currentWith_";
  protected final String TEXT_296 = "+2;";
  protected final String TEXT_297 = NL + "\t\t\t\t\t\t\tcurrentWith_";
  protected final String TEXT_298 = ";" + NL + "\t\t\t\t\t\t\tfitWidth_";
  protected final String TEXT_299 = NL + "\t\t\t\t\t\texcelDynamicUtil_";
  protected final String TEXT_300 = ".writeValuesToExcelFile(";
  protected final String TEXT_301 = ", writableSheet_";
  protected final String TEXT_302 = ",columnIndex_";
  protected final String TEXT_303 = ",startRowNum_";
  protected final String TEXT_304 = ");" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_305 = NL + "\t\t\t\t\t\t\texcelDynamicUtil_";
  protected final String TEXT_306 = ".autoDynamicColumnSize(writableSheet_";
  protected final String TEXT_307 = NL + "\t    \t\t\t\t} " + NL + "\t\t\t\t\t";
  protected final String TEXT_308 = NL + "\t\t\t" + NL + "\t\t}" + NL + "\t\t" + NL + "\t\tFileOutputExcelUtil_";
  protected final String TEXT_309 = " fileOutputExcelUtil_";
  protected final String TEXT_310 = "=new FileOutputExcelUtil_";
  protected final String TEXT_311 = NL + "\t\tif (startRowNum_";
  protected final String TEXT_312 = " == ";
  protected final String TEXT_313 = "){";
  protected final String TEXT_314 = " == 0){";
  protected final String TEXT_315 = NL + "\t//modif end";
  protected final String TEXT_316 = NL + "\t\t\t\tfileOutputExcelUtil_";
  protected final String TEXT_317 = ".putHeaderValue_";
  protected final String TEXT_318 = "(writableSheet_";
  protected final String TEXT_319 = ",";
  protected final String TEXT_320 = "format_";
  protected final String TEXT_321 = "null";
  protected final String TEXT_322 = ",fitWidth_";
  protected final String TEXT_323 = ",nb_line_";
  protected final String TEXT_324 = NL + "\t\t//modif start";
  protected final String TEXT_325 = ", nb_line_";
  protected final String TEXT_326 = NL + "\t\t//modif end" + NL + "\t\tfitWidth_";
  protected final String TEXT_327 = NL + "\t\tnb_line_";
  protected final String TEXT_328 = " ++;" + NL + "\t}";
  protected final String TEXT_329 = NL + "\t\t";
  protected final String TEXT_330 = NL + "\t\tString fileName_";
  protected final String TEXT_331 = "\t" + NL + "\t\tjava.io.File file_";
  protected final String TEXT_332 = " = 0;" + NL + "\t\torg.talend.ExcelTool xlsxTool_";
  protected final String TEXT_333 = " = new org.talend.ExcelTool();" + NL + "\t\t";
  protected final String TEXT_334 = NL + "        xlsxTool_";
  protected final String TEXT_335 = ".setPasswordProtection(password_";
  protected final String TEXT_336 = NL + "\t\t\tint\tflushRowNum_";
  protected final String TEXT_337 = ";" + NL + "\t\t\tint bufferCount_";
  protected final String TEXT_338 = "=0;" + NL + "\t\t\txlsxTool_";
  protected final String TEXT_339 = ".setRowAccessWindowSize(-1);" + NL + "\t\t\t//turn-off auto flush";
  protected final String TEXT_340 = NL + "\t\txlsxTool_";
  protected final String TEXT_341 = ".setSheet(";
  protected final String TEXT_342 = ");" + NL + "\t\txlsxTool_";
  protected final String TEXT_343 = ".setAppend(";
  protected final String TEXT_344 = ".setRecalculateFormula(";
  protected final String TEXT_345 = ".setXY(";
  protected final String TEXT_346 = ");" + NL + "\t\t";
  protected final String TEXT_347 = NL + "\t\tjava.util.concurrent.ConcurrentHashMap<java.lang.Object, java.lang.Object> chm_";
  protected final String TEXT_348 = " = (java.util.concurrent.ConcurrentHashMap<java.lang.Object, java.lang.Object>) globalMap.get(\"concurrentHashMap\");" + NL + "\t\tjava.lang.Object lockObj_";
  protected final String TEXT_349 = " = chm_";
  protected final String TEXT_350 = ".computeIfAbsent(\"EXCEL_OUTPUT_LOCK_OBJ_";
  protected final String TEXT_351 = "\", k -> new Object());" + NL + "\t\tsynchronized (lockObj_";
  protected final String TEXT_352 = ") {" + NL + "\t\t\t";
  protected final String TEXT_353 = NL + "\t\t\t\txlsxTool_";
  protected final String TEXT_354 = ".prepareXlsmFile(fileName_";
  protected final String TEXT_355 = ".prepareXlsxFile(fileName_";
  protected final String TEXT_356 = ");" + NL + "\t\t\t";
  protected final String TEXT_357 = NL + "\t\t}" + NL + "\t\t";
  protected final String TEXT_358 = ".prepareStream();" + NL + "\t\t";
  protected final String TEXT_359 = ".setFont(\"";
  protected final String TEXT_360 = "\");" + NL + "\t\t";
  protected final String TEXT_361 = NL + "\t\t\tclass FileOutputExcelUtil_";
  protected final String TEXT_362 = NL + "\t\t\t\tExcelDynamicUtil_";
  protected final String TEXT_363 = NL + "\t\t\t\tpublic void putHeaderValue_";
  protected final String TEXT_364 = "(final org.talend.ExcelTool xlsxTool_";
  protected final String TEXT_365 = NL + "\t\t\t\t\txlsxTool_";
  protected final String TEXT_366 = ".addCellValue(\"";
  protected final String TEXT_367 = "\");";
  protected final String TEXT_368 = NL + "\t\t\t\t}";
  protected final String TEXT_369 = NL + "\t\t\t\tpublic void setColAutoSize_";
  protected final String TEXT_370 = NL + "\t\t\t\t\t\tcolumnIndex_";
  protected final String TEXT_371 = ";" + NL + "\t\t\t\t\t";
  protected final String TEXT_372 = ".setColAutoSize(columnIndex_";
  protected final String TEXT_373 = NL + "    \t\t\tpublic void putValue_";
  protected final String TEXT_374 = "," + NL + "    \t\t\t\tfinal org.talend.ExcelTool xlsxTool_";
  protected final String TEXT_375 = NL + "\t\t\t\t";
  protected final String TEXT_376 = "\t\t\t\t\t";
  protected final String TEXT_377 = NL + "\t\t\t\t\t\t\txlsxTool_";
  protected final String TEXT_378 = ".addCellValue(";
  protected final String TEXT_379 = "\t\t\t\t\t" + NL + "\t\t\t\t\t\t\txlsxTool_";
  protected final String TEXT_380 = ".addCellValue(java.nio.charset.Charset.defaultCharset().decode(java.nio.ByteBuffer.wrap(";
  protected final String TEXT_381 = ")).toString());";
  protected final String TEXT_382 = ".addCellValue(FormatterUtils.format_Number(String.valueOf(";
  protected final String TEXT_383 = "));\t\t\t\t" + NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_384 = "));" + NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_385 = "\t\t" + NL + "\t\t\t\t\t\t\txlsxTool_";
  protected final String TEXT_386 = ".addCellValue((";
  protected final String TEXT_387 = ").doubleValue());";
  protected final String TEXT_388 = ".addCellValue(Double.parseDouble(String.valueOf(";
  protected final String TEXT_389 = ")));";
  protected final String TEXT_390 = ".addCellValue(String.valueOf(";
  protected final String TEXT_391 = ", xlsxTool_";
  protected final String TEXT_392 = ".autoDynamicColumnSize(xlsxTool_";
  protected final String TEXT_393 = NL + "\t    \t\t\t\t} else {" + NL + "\t    \t\t\t\t\txlsxTool_";
  protected final String TEXT_394 = ".addCellNullValue();" + NL + "\t    \t\t\t\t}" + NL + "\t\t\t\t\t";
  protected final String TEXT_395 = NL + "\t\t\t}" + NL + "\t\t\t" + NL + "\t\t\tFileOutputExcelUtil_";
  protected final String TEXT_396 = NL + "\t\tif (xlsxTool_";
  protected final String TEXT_397 = ".getStartRow() == 0){" + NL + "\t\t";
  protected final String TEXT_398 = ".addRow();" + NL + "\t\t";
  protected final String TEXT_399 = NL + "\t\t\t\t\tfileOutputExcelUtil_";
  protected final String TEXT_400 = "(xlsxTool_";
  protected final String TEXT_401 = "++; " + NL + "\t\t";
  protected final String TEXT_402 = NL + "\t}" + NL + "\t\t";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
	//this util class use by set log4j debug paramters
	class DefaultLog4jFileUtil {
	
		INode node = null;
	    String cid = null;
 		boolean isLog4jEnabled = false;
 		String label = null;
 		
 		public DefaultLog4jFileUtil(){
 		}
 		public DefaultLog4jFileUtil(INode node) {
 			this.node = node;
 			this.cid = node.getUniqueName();
 			this.label = cid;
			this.isLog4jEnabled = ("true").equals(org.talend.core.model.process.ElementParameterParser.getValue(node.getProcess(), "__LOG4J_ACTIVATE__"));
 		}
 		
 		public void setCid(String cid) {
 			this.cid = cid;
 		}
 		
		//for all tFileinput* components 
		public void startRetriveDataInfo() {
			if (isLog4jEnabled) {
			
    stringBuffer.append(TEXT_1);
    stringBuffer.append(label);
    stringBuffer.append(TEXT_2);
    
			}
		}
		
		public void retrievedDataNumberInfo() {
			if (isLog4jEnabled) {
			
    stringBuffer.append(TEXT_3);
    stringBuffer.append(label);
    stringBuffer.append(TEXT_4);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_5);
    
			}
		}
		
		public void retrievedDataNumberInfoFromGlobalMap(INode node) {
			if (isLog4jEnabled) {
			
    stringBuffer.append(TEXT_3);
    stringBuffer.append(label);
    stringBuffer.append(TEXT_6);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_7);
    
			}
		}
		
		//for all tFileinput* components 
		public void retrievedDataNumberInfo(INode node) {
			if (isLog4jEnabled) {
			
    stringBuffer.append(TEXT_3);
    stringBuffer.append(label);
    stringBuffer.append(TEXT_4);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_5);
    
			}
		}
		
		public void writeDataFinishInfo(INode node) {
			if(isLog4jEnabled){
			
    stringBuffer.append(TEXT_3);
    stringBuffer.append(label);
    stringBuffer.append(TEXT_8);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_5);
    
			}
		}
		
 		//TODO delete it and remove all log4jSb parameter from components
		public void componentStartInfo(INode node) {
			if (isLog4jEnabled) {
			
    stringBuffer.append(TEXT_9);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_10);
    
			}
		}
		
		//TODO rename or delete it
		public void debugRetriveData(INode node,boolean hasIncreased) {
			if(isLog4jEnabled){
			
    stringBuffer.append(TEXT_3);
    stringBuffer.append(label);
    stringBuffer.append(TEXT_11);
    stringBuffer.append(cid);
    stringBuffer.append(hasIncreased?"":"+1");
    stringBuffer.append(TEXT_12);
    
			}
		}
		
		//TODO rename or delete it
		public void debugRetriveData(INode node) {
			debugRetriveData(node,true);
		}
		
		//TODO rename or delete it
		public void debugWriteData(INode node) {
			if(isLog4jEnabled){
			
    stringBuffer.append(TEXT_3);
    stringBuffer.append(label);
    stringBuffer.append(TEXT_13);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_14);
    
			}
		}
		
		public void logCurrentRowNumberInfo() {
			if(isLog4jEnabled){
			
    stringBuffer.append(TEXT_3);
    stringBuffer.append(label);
    stringBuffer.append(TEXT_15);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_16);
    
			}
		}
		
		public void logDataCountInfo() {
			if(isLog4jEnabled){
			
    stringBuffer.append(TEXT_3);
    stringBuffer.append(label);
    stringBuffer.append(TEXT_17);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_5);
    
			}
		}
	}
	
	final DefaultLog4jFileUtil log4jFileUtil = new DefaultLog4jFileUtil((INode)(((org.talend.designer.codegen.config.CodeGeneratorArgument)argument).getArgument()));
	
    stringBuffer.append(TEXT_18);
    
CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
INode node = (INode)codeGenArgument.getArgument();
String cid = node.getUniqueName();
boolean version07 = ("true").equals(ElementParameterParser.getValue(node,"__VERSION_2007__"));
	
boolean useStream = ("true").equals(ElementParameterParser.getValue(node,"__USESTREAM__"));
String outStream = ElementParameterParser.getValue(node,"__STREAMNAME__");

String filename = ElementParameterParser.getValue(node, "__FILENAME__");
String sheetname = ElementParameterParser.getValue(node, "__SHEETNAME__");
boolean firstCellYAbsolute = ("true").equals(ElementParameterParser.getValue(node, "__FIRST_CELL_Y_ABSOLUTE__"));
String firstCellXStr = ElementParameterParser.getValue(node, "__FIRST_CELL_X__");
String firstCellYStr = ElementParameterParser.getValue(node, "__FIRST_CELL_Y__");
boolean keepCellFormating = ("true").equals(ElementParameterParser.getValue(node, "__KEEP_CELL_FORMATING__"));
String font = ElementParameterParser.getValue(node, "__FONT__");
boolean isSettingFont = font !=null && font.length()!=0;
boolean isDeleteEmptyFile = ElementParameterParser.getValue(node, "__DELETE_EMPTYFILE__").equals("true");
boolean isIncludeHeader = ("true").equals(ElementParameterParser.getValue(node, "__INCLUDEHEADER__"));
boolean isAppendFile = ("true").equals(ElementParameterParser.getValue(node, "__APPEND_FILE__" ));
boolean isAppendSheet = ("true").equals(ElementParameterParser.getValue(node, "__APPEND_SHEET__" ));

boolean flushOnRow=("true").equals(ElementParameterParser.getValue(node, "__FLUSHONROW__" ));
String flushRowNum=ElementParameterParser.getValue(node, "__FLUSHONROW_NUM__" );

int schemaOptNum=100;
String schemaOptNumStr=ElementParameterParser.getValue(node, "__SCHEMA_OPT_NUM__");
if(schemaOptNumStr!=null && !"".equals(schemaOptNumStr) && !"\"\"".equals(schemaOptNumStr)){
	schemaOptNum  = Integer.parseInt(schemaOptNumStr);
}

String allColumnAutoSize = ElementParameterParser.getValue(node, "__IS_ALL_AUTO_SZIE__");
boolean isAllColumnAutoSize = (allColumnAutoSize!=null&&!("").equals(allColumnAutoSize))?("true").equals(allColumnAutoSize):false;
List<Map<String, String>> autoSizeList = (List<Map<String,String>>)ElementParameterParser.getObjectValue(node, "__AUTO_SZIE_SETTING__");

String advancedSeparatorStr = ElementParameterParser.getValue(node, "__ADVANCED_SEPARATOR__");
boolean advancedSeparator = (advancedSeparatorStr!=null&&!("").equals(advancedSeparatorStr))?("true").equals(advancedSeparatorStr):false;
String thousandsSeparator = ElementParameterParser.getValueWithJavaType(node, "__THOUSANDS_SEPARATOR__", JavaTypesManager.CHARACTER);
String decimalSeparator = ElementParameterParser.getValueWithJavaType(node, "__DECIMAL_SEPARATOR__", JavaTypesManager.CHARACTER); 
Map<String,String> autColSizeMaping=new HashMap<String,String>();

List< ? extends IConnection> conns = node.getIncomingConnections();
IConnection conn = null;
if((conns == null) || (conns.size() < 1) || ((conn = conns.get(0)) == null)) {
	return "";
}

List<IMetadataTable> metadatas = node.getMetadataList();
if ((metadatas!=null)&&(metadatas.size()>0)) {
    IMetadataTable metadata = metadatas.get(0);
    if (metadata!=null) {
    	List<IMetadataColumn> columns = metadata.getListColumns();
		boolean isLog4jEnabled = ("true").equals(ElementParameterParser.getValue(node.getProcess(), "__LOG4J_ACTIVATE__"));

		boolean protectFile = ("true").equals(ElementParameterParser.getValue(node, "__PROTECT_FILE__")) ? true : false;
		if (protectFile) {
            String passwordFieldName = "__PASSWORD__";
        
    if (ElementParameterParser.canEncrypt(node, passwordFieldName)) {
    stringBuffer.append(TEXT_19);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_20);
    stringBuffer.append(ElementParameterParser.getEncryptedValue(node, passwordFieldName));
    stringBuffer.append(TEXT_21);
    } else {
    stringBuffer.append(TEXT_22);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_23);
    stringBuffer.append( ElementParameterParser.getValue(node, passwordFieldName));
    stringBuffer.append(TEXT_24);
    }
    stringBuffer.append(TEXT_25);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_26);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_27);
    
        }

		boolean hasDynamic = false;
		int dynamic_index = 0;
		String datePattern = "\"dd-MM-yyyy\"";
		for(int i=0; columns!=null && i< columns.size(); i++) {
			IMetadataColumn column = columns.get(i);
	        if(!hasDynamic && column.getTalendType().equals("id_Dynamic")){
	            dynamic_index = i+1;
	            hasDynamic = true;
	            datePattern= column.getPattern();
	        }
	        if(isAllColumnAutoSize){
	        	autColSizeMaping.put(column.getLabel(),"true");
	        }else{
	        	autColSizeMaping.put(column.getLabel(),autoSizeList.get(i).get("IS_AUTO_SIZE"));
	        	
	        }
		}
		if(hasDynamic){
			
    stringBuffer.append(TEXT_28);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_29);
    
			if(!version07){
			
    stringBuffer.append(TEXT_30);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_31);
    
					if(isSettingFont){
					
    stringBuffer.append(TEXT_32);
    stringBuffer.append(font);
    stringBuffer.append(TEXT_33);
    stringBuffer.append(datePattern );
    stringBuffer.append(TEXT_34);
    
					}else{
					
    stringBuffer.append(TEXT_35);
    stringBuffer.append(datePattern );
    stringBuffer.append(TEXT_34);
    
					}
					
    stringBuffer.append(TEXT_36);
    stringBuffer.append(advancedSeparator);
    stringBuffer.append(TEXT_37);
    
				if(isIncludeHeader){
				
    stringBuffer.append(TEXT_38);
    stringBuffer.append(NodeUtil.getPrivateConnClassName(conn));
    stringBuffer.append(TEXT_39);
    
						if(firstCellYAbsolute){
						
    stringBuffer.append(TEXT_40);
    stringBuffer.append(firstCellYStr);
    stringBuffer.append(TEXT_41);
    
						}else{
						
    stringBuffer.append(TEXT_42);
    
						}
						
    stringBuffer.append(TEXT_43);
    
						for(int i=0; columns!=null && i< columns.size(); i++) {
							IMetadataColumn column = columns.get(i);
					        if(column.getTalendType().equals("id_Dynamic")){
					        
    stringBuffer.append(TEXT_44);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_45);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_46);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_47);
    if (isSettingFont) {
    stringBuffer.append(TEXT_48);
    }
    stringBuffer.append(TEXT_49);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_50);
    
					        }else{
					        
    stringBuffer.append(TEXT_51);
    stringBuffer.append(i);
    if(i+1>dynamic_index){
    stringBuffer.append(TEXT_52);
    }
    stringBuffer.append(TEXT_53);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_54);
    if (isSettingFont) {
    stringBuffer.append(TEXT_48);
    }
    stringBuffer.append(TEXT_55);
    stringBuffer.append(i);
    if(i+1>dynamic_index){
    stringBuffer.append(TEXT_52);
    }
    stringBuffer.append(TEXT_56);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_57);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_58);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_59);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_60);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_61);
    
					        }
						}
						
    stringBuffer.append(TEXT_62);
    
				}
				
    stringBuffer.append(TEXT_63);
    stringBuffer.append(dynamic_index-1);
    if(firstCellYAbsolute){
    stringBuffer.append(TEXT_64);
    stringBuffer.append(firstCellXStr);
    }
    stringBuffer.append(TEXT_65);
    if(isSettingFont){
    stringBuffer.append(TEXT_48);
    }
    stringBuffer.append(TEXT_66);
    stringBuffer.append(advancedSeparator);
    stringBuffer.append(TEXT_67);
    stringBuffer.append( thousandsSeparator );
    stringBuffer.append(TEXT_68);
    stringBuffer.append( decimalSeparator );
    stringBuffer.append(TEXT_69);
    if(isSettingFont){
    stringBuffer.append(TEXT_48);
    }
    stringBuffer.append(TEXT_70);
    if(isSettingFont){
    stringBuffer.append(TEXT_48);
    }
    stringBuffer.append(TEXT_71);
    if(isSettingFont){
    stringBuffer.append(TEXT_48);
    }
    stringBuffer.append(TEXT_72);
    
			}else{
			
    stringBuffer.append(TEXT_73);
    
				if(isIncludeHeader){
				
    stringBuffer.append(TEXT_74);
    stringBuffer.append(NodeUtil.getPrivateConnClassName(conn));
    stringBuffer.append(TEXT_75);
    
							if(!firstCellYAbsolute) {
							
    stringBuffer.append(TEXT_76);
    
							}
							
    stringBuffer.append(TEXT_77);
    
								for (int i = 0; i < columns.size(); i++) {
									IMetadataColumn column = columns.get(i);
									if(column.getTalendType().equals("id_Dynamic")){
									
    stringBuffer.append(TEXT_78);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_79);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_80);
    
									}else{
									
    stringBuffer.append(TEXT_81);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_82);
    
									}
								}
							if(!firstCellYAbsolute) {
							
    stringBuffer.append(TEXT_83);
    
							}
							
    stringBuffer.append(TEXT_84);
    
				}
				
    stringBuffer.append(TEXT_85);
    stringBuffer.append(datePattern);
    stringBuffer.append(TEXT_86);
    stringBuffer.append(advancedSeparator);
    stringBuffer.append(TEXT_87);
    stringBuffer.append( thousandsSeparator );
    stringBuffer.append(TEXT_68);
    stringBuffer.append( decimalSeparator );
    stringBuffer.append(TEXT_88);
    stringBuffer.append(dynamic_index-1);
    stringBuffer.append(TEXT_89);
    
			}
			
    stringBuffer.append(TEXT_90);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_91);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_92);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_93);
    
		}
		
    stringBuffer.append(TEXT_94);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_95);
    
    	if(!version07){//version judgement

    stringBuffer.append(TEXT_96);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_97);
    
		if(!useStream){ // the part of the file path

    stringBuffer.append(TEXT_98);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_99);
    stringBuffer.append(filename);
    stringBuffer.append(TEXT_100);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_101);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_102);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_103);
    
			if(isAppendFile){

    stringBuffer.append(TEXT_104);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_105);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_106);
    
			}
			if(("true").equals(ElementParameterParser.getValue(node,"__CREATE__"))){

    stringBuffer.append(TEXT_107);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_108);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_109);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_110);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_111);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_112);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_113);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_114);
    }
    stringBuffer.append(TEXT_115);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_116);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_112);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_117);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_118);
    }
    stringBuffer.append(TEXT_119);
    
			}
		}

    stringBuffer.append(TEXT_120);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_121);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_122);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_123);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_124);
    stringBuffer.append(ElementParameterParser.getValue(node,"__ENCODING__") );
    stringBuffer.append(TEXT_21);
    
		if(useStream){ // the part of the output stream support

    stringBuffer.append(TEXT_125);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_126);
    stringBuffer.append(outStream );
    stringBuffer.append(TEXT_127);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_21);
    
		}else{
			if(isAppendFile){

    stringBuffer.append(TEXT_128);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_129);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_130);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_131);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_132);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_133);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_134);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_135);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_136);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_137);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_138);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_139);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_140);
    
			} else {

    stringBuffer.append(TEXT_125);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_138);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_139);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_21);
    
			}
		}

    stringBuffer.append(TEXT_141);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_142);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_143);
    stringBuffer.append(sheetname );
    stringBuffer.append(TEXT_144);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_145);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_142);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_146);
    stringBuffer.append(sheetname );
    stringBuffer.append(TEXT_147);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_148);
    if(!useStream && isAppendFile && !isAppendSheet){
    stringBuffer.append(TEXT_149);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_142);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_150);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_151);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_152);
    stringBuffer.append(sheetname );
    stringBuffer.append(TEXT_153);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_154);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_142);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_146);
    stringBuffer.append(sheetname );
    stringBuffer.append(TEXT_147);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_155);
    }
    stringBuffer.append(TEXT_156);
    if(firstCellYAbsolute){
    stringBuffer.append(TEXT_157);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_23);
    stringBuffer.append(firstCellYStr);
    stringBuffer.append(TEXT_27);
    }else{
    stringBuffer.append(TEXT_158);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_159);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_160);
    }
    stringBuffer.append(TEXT_161);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_162);
    stringBuffer.append(columns.size());
    stringBuffer.append(TEXT_163);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_164);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_165);
    stringBuffer.append(columns.size());
    stringBuffer.append(TEXT_166);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_167);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_168);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_169);
    stringBuffer.append(cid);
    if(firstCellYAbsolute){
    stringBuffer.append(TEXT_64);
    stringBuffer.append(firstCellXStr);
    }
    stringBuffer.append(TEXT_170);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_171);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_172);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_173);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_174);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_171);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_175);
    if(isSettingFont){
    stringBuffer.append(TEXT_176);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_177);
    stringBuffer.append(font);
    stringBuffer.append(TEXT_178);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_179);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_180);
    }
    stringBuffer.append(TEXT_181);
    
    	for (int i = 0; i < columns.size(); i++) {
    		IMetadataColumn column = columns.get(i);
    		JavaType javaType = JavaTypesManager.getJavaTypeFromId(column.getTalendType());
    		if (javaType == JavaTypesManager.DATE || column.getTalendType().equals("id_Dynamic")){
    			String pattern = column.getPattern() == null || column.getPattern().trim().length() == 0 ? null : column.getPattern();
    			if(pattern != null && pattern.trim().length() != 0){
    				if(isSettingFont){

    stringBuffer.append(TEXT_182);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_183);
    stringBuffer.append( cid);
    stringBuffer.append(TEXT_184);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_185);
    stringBuffer.append(pattern );
    stringBuffer.append(TEXT_186);
    
					}else{

    stringBuffer.append(TEXT_187);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_183);
    stringBuffer.append( cid);
    stringBuffer.append(TEXT_188);
    stringBuffer.append(pattern );
    stringBuffer.append(TEXT_186);
    	
					}
				}else{

    stringBuffer.append(TEXT_189);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_190);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_191);
    				}
			}
		
	    }

    stringBuffer.append(TEXT_192);
    
	int sizeColumns = columns.size();
	if(sizeColumns> schemaOptNum){//TD64

    stringBuffer.append(TEXT_193);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_194);
    
		if(hasDynamic){

    stringBuffer.append(TEXT_195);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_91);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_92);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_196);
    
		}
		for (int i = 0; i < sizeColumns; i++) {//TD128
			IMetadataColumn column = columns.get(i);
			if(i%schemaOptNum==0){//TD256

    stringBuffer.append(TEXT_197);
    stringBuffer.append(i/schemaOptNum);
    stringBuffer.append(TEXT_198);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_199);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_200);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_201);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_202);
    
			}//TD256
			
			if(firstCellYAbsolute){

    stringBuffer.append(TEXT_203);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_204);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_205);
    stringBuffer.append(firstCellXStr);
    stringBuffer.append(TEXT_206);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_56);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_54);
    
				if (isSettingFont) {

    stringBuffer.append(TEXT_207);
    stringBuffer.append(cid );
    
				}

    stringBuffer.append(TEXT_208);
    
			}else{

    stringBuffer.append(TEXT_203);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_204);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_206);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_56);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_54);
    
				if (isSettingFont) {

    stringBuffer.append(TEXT_207);
    stringBuffer.append(cid );
    
				}

    stringBuffer.append(TEXT_209);
    
			}

    stringBuffer.append(TEXT_210);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_211);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_212);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_211);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_213);
    stringBuffer.append(column.getLabel().length());
    stringBuffer.append(TEXT_214);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_211);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_215);
    stringBuffer.append(column.getLabel().length());
    stringBuffer.append(TEXT_27);
    
			if((i+1)%schemaOptNum==0){

    stringBuffer.append(TEXT_216);
    
			}
		}//TD128
		
		if(sizeColumns>0&&(sizeColumns%schemaOptNum)>0){//TD512

    stringBuffer.append(TEXT_216);
    
		}//TD512
		
		boolean emptyMethod = true;
		
		for(int i=0;i<sizeColumns;i++){//TD1024
			IMetadataColumn column = columns.get(i);
			
			if(i%schemaOptNum==0){
				if(!isAllColumnAutoSize) {
					if(autoSizeList.size() == columns.size()){
						for(int j=0;(j<schemaOptNum) && (i+j<sizeColumns);j++) {
    						Map<String,String> tmp= autoSizeList.get(i+j);
    						if(("true").equals(tmp.get("IS_AUTO_SIZE")) && (!columns.get(i+j).getTalendType().equals("id_Dynamic"))){
    							emptyMethod = false;
    							break;
    						}
						}
					}
				} else {
					emptyMethod = false;
				}
				
				if(!emptyMethod) {

    stringBuffer.append(TEXT_217);
    stringBuffer.append(i/schemaOptNum);
    stringBuffer.append(TEXT_198);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_218);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_219);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_220);
    
				}
			}
		if(!column.getTalendType().equals("id_Dynamic")){
			if(isAllColumnAutoSize){
				if(hasDynamic && i+1>dynamic_index){
				
    stringBuffer.append(TEXT_221);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_222);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_223);
    stringBuffer.append(i-1);
    stringBuffer.append(TEXT_224);
    
				}else{
				
    stringBuffer.append(TEXT_221);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_23);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_224);
    
				}

    stringBuffer.append(TEXT_225);
    if(firstCellYAbsolute){
    stringBuffer.append(TEXT_226);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_227);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_228);
    stringBuffer.append(firstCellXStr);
    stringBuffer.append(TEXT_229);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_211);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_230);
    }else{
    stringBuffer.append(TEXT_226);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_227);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_231);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_211);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_230);
    }
    stringBuffer.append(TEXT_232);
    
     		} else {
     			if(autoSizeList.size() == columns.size()){
    				Map<String,String> tmp= autoSizeList.get(i);
            		if(("true").equals(tmp.get("IS_AUTO_SIZE"))){
						if(hasDynamic && i+1>dynamic_index){
						
    stringBuffer.append(TEXT_233);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_222);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_223);
    stringBuffer.append(i-1);
    stringBuffer.append(TEXT_234);
    
						}else{
						
    stringBuffer.append(TEXT_233);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_23);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_234);
    
						}

    stringBuffer.append(TEXT_226);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_227);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_231);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_211);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_235);
    
            		}
        		}
     		}
     	}
     		if(!emptyMethod && ((i+1)%schemaOptNum==0)){
     			emptyMethod = true;

    stringBuffer.append(TEXT_216);
    
     		}
     	}//TD1024
     	
     	if(!emptyMethod && (sizeColumns>0&&(sizeColumns%schemaOptNum)>0)){

    stringBuffer.append(TEXT_216);
    
     	}
     	
     	for(int i=0;i<sizeColumns;i++){//TD2048
			IMetadataColumn column = columns.get(i);
			if(i%schemaOptNum==0){

    stringBuffer.append(TEXT_236);
    stringBuffer.append(i/schemaOptNum);
    stringBuffer.append(TEXT_237);
    stringBuffer.append(NodeUtil.getPrivateConnClassName(conn) );
    stringBuffer.append(TEXT_238);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_239);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_240);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_241);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_200);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_242);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_243);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_220);
    
			}

    stringBuffer.append(TEXT_244);
    stringBuffer.append(TEXT_245);
    
					JavaType javaType = JavaTypesManager.getJavaTypeFromId(column.getTalendType());
					boolean isPrimitive = JavaTypesManager.isJavaPrimitiveType( javaType, column.isNullable());
					if(!isPrimitive) {
    				
    stringBuffer.append(TEXT_246);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_247);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_248);
    
    				} 
    				
    stringBuffer.append(TEXT_249);
    
					//Detect the format required for the cell
					String jxlWriteType;
    				int staticWidth = 0;
    				boolean isNumber = false;
					if(javaType == JavaTypesManager.BOOLEAN){
						staticWidth=5;
						jxlWriteType="Boolean";
					}else if(javaType == JavaTypesManager.DATE){
						jxlWriteType="DateTime";
				    }else if(javaType == JavaTypesManager.STRING||
				    		 javaType == JavaTypesManager.CHARACTER||
				    		 javaType == JavaTypesManager.BYTE_ARRAY||
				    		 javaType == JavaTypesManager.LIST||
				    		 javaType == JavaTypesManager.OBJECT||
				    		 column.getTalendType().equals("id_Dynamic")||
				    		 (advancedSeparator && JavaTypesManager.isNumberType(javaType, column.isNullable()))
				    		 ){
				    	jxlWriteType="Label";
					}else{
						isNumber=true;
						jxlWriteType="Number";
					};
					if(hasDynamic && i+1>dynamic_index){
					
    stringBuffer.append(TEXT_250);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_222);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_223);
    stringBuffer.append(i-1);
    stringBuffer.append(TEXT_251);
    
					}else{
					
    stringBuffer.append(TEXT_250);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_23);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_251);
    
					}
					if(!column.getTalendType().equals("id_Dynamic")){
   				
    stringBuffer.append(TEXT_252);
    if(firstCellYAbsolute){
    stringBuffer.append(TEXT_253);
    if(keepCellFormating){
    stringBuffer.append(TEXT_254);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_183);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_159);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_255);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_205);
    stringBuffer.append(firstCellXStr);
    stringBuffer.append(TEXT_256);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_257);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_258);
    }
    stringBuffer.append(TEXT_259);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_183);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_260);
    stringBuffer.append(jxlWriteType);
    stringBuffer.append(TEXT_261);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_205);
    stringBuffer.append(firstCellXStr);
    stringBuffer.append(TEXT_256);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_257);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_262);
    }else{
    stringBuffer.append(TEXT_259);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_183);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_260);
    stringBuffer.append(jxlWriteType);
    stringBuffer.append(TEXT_261);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_256);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_257);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_263);
    }
    stringBuffer.append(TEXT_264);
    
    				String pattern = column.getPattern() == null || column.getPattern().trim().length() == 0 ? null : column.getPattern();
    				if (javaType == JavaTypesManager.DATE && pattern != null && pattern.trim().length() != 0) {
						staticWidth = pattern.trim().length();

    stringBuffer.append(TEXT_265);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_247);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_266);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_183);
    stringBuffer.append( cid);
    
					} else {
						if(javaType == JavaTypesManager.CHARACTER) {

    stringBuffer.append(TEXT_267);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_247);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_69);
    
						} else if(javaType == JavaTypesManager.OBJECT || javaType == JavaTypesManager.LIST){

    stringBuffer.append(TEXT_268);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_247);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_269);
    
						} else if(javaType == JavaTypesManager.BYTE_ARRAY){

    stringBuffer.append(TEXT_270);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_247);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_271);
    
						} else if(advancedSeparator && JavaTypesManager.isNumberType(javaType, column.isNullable())) { 

    stringBuffer.append(TEXT_272);
     if(javaType == JavaTypesManager.BIGDECIMAL) {
    stringBuffer.append(TEXT_273);
    stringBuffer.append(column.getPrecision() == null? conn.getName() + "." + column.getLabel() : conn.getName() + "." + column.getLabel() + ".setScale(" + column.getPrecision() + ", java.math.RoundingMode.HALF_UP)" );
    stringBuffer.append(TEXT_274);
    stringBuffer.append( thousandsSeparator );
    stringBuffer.append(TEXT_68);
    stringBuffer.append( decimalSeparator );
    stringBuffer.append(TEXT_275);
     } else { 
    stringBuffer.append(TEXT_273);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_247);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_274);
    stringBuffer.append( thousandsSeparator );
    stringBuffer.append(TEXT_68);
    stringBuffer.append( decimalSeparator );
    stringBuffer.append(TEXT_275);
     } 
    
						} else if (javaType == JavaTypesManager.BIGDECIMAL) {

    stringBuffer.append(TEXT_276);
    stringBuffer.append(column.getPrecision() == null? conn.getName() + "." + column.getLabel() : conn.getName() + "." + column.getLabel() + ".setScale(" + column.getPrecision() + ", java.math.RoundingMode.HALF_UP)" );
    stringBuffer.append(TEXT_277);
    
					}else {

    stringBuffer.append(TEXT_265);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_247);
    stringBuffer.append(column.getLabel() );
    				
					}
					if(font !=null && font.length()!=0){ 

    stringBuffer.append(TEXT_278);
    stringBuffer.append(cid);
    
					}
				}

    stringBuffer.append(TEXT_279);
    if(keepCellFormating && firstCellYAbsolute){
    stringBuffer.append(TEXT_280);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_183);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_281);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_183);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_282);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_183);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_283);
    
							}
							
    stringBuffer.append(TEXT_284);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_285);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_183);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_21);
    
					if(isNumber){

    stringBuffer.append(TEXT_286);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_183);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_287);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_183);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_288);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_183);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_289);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_183);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_290);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_183);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_27);
    
					}else{

    stringBuffer.append(TEXT_286);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_183);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_291);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_183);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_292);
    
					}
					if(staticWidth ==0){

    stringBuffer.append(TEXT_293);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_211);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_212);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_211);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_294);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_183);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_214);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_211);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_295);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_183);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_296);
    
					}else{

    stringBuffer.append(TEXT_297);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_183);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_99);
    stringBuffer.append(staticWidth);
    stringBuffer.append(TEXT_298);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_211);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_212);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_211);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_294);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_183);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_214);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_211);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_295);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_183);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_296);
    
					}
					}else{
					
    stringBuffer.append(TEXT_299);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_300);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_247);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_301);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_302);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_64);
    stringBuffer.append(firstCellYAbsolute?firstCellXStr:"0");
    stringBuffer.append(TEXT_303);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_257);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_304);
    
						if("true".equalsIgnoreCase(autColSizeMaping.get(column.getLabel()))){
						
    stringBuffer.append(TEXT_305);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_306);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_302);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_64);
    stringBuffer.append(firstCellYAbsolute?firstCellXStr:"0");
    stringBuffer.append(TEXT_304);
    
						}
					}
					if(!isPrimitive) {
    				
    stringBuffer.append(TEXT_307);
    
    				} 
    			
    
     		if((i+1)%schemaOptNum==0){

    stringBuffer.append(TEXT_216);
    
     		}
		}//TD2048
		
     	if(sizeColumns>0&&(sizeColumns%schemaOptNum)>0){

    stringBuffer.append(TEXT_216);
    
     	}

    stringBuffer.append(TEXT_308);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_309);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_310);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_196);
    
	}//TD64

    stringBuffer.append(TEXT_181);
    
if(!hasDynamic && isIncludeHeader){
	if(firstCellYAbsolute){

    stringBuffer.append(TEXT_311);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_312);
    stringBuffer.append(firstCellYStr);
    stringBuffer.append(TEXT_313);
    
	}else{

    stringBuffer.append(TEXT_311);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_314);
    
	}

    stringBuffer.append(TEXT_315);
    
	for (int i = 0; i < columns.size(); i++) {
		IMetadataColumn column = columns.get(i);
		if(sizeColumns > schemaOptNum){
        	if(i%schemaOptNum==0){
        		if(firstCellYAbsolute) {

    stringBuffer.append(TEXT_316);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_317);
    stringBuffer.append(i/schemaOptNum);
    stringBuffer.append(TEXT_318);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_303);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_319);
    if (isSettingFont) {
    stringBuffer.append(TEXT_320);
    stringBuffer.append(cid );
    } else {
    stringBuffer.append(TEXT_321);
    }
    stringBuffer.append(TEXT_322);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_21);
    
        		} else {

    stringBuffer.append(TEXT_316);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_317);
    stringBuffer.append(i/schemaOptNum);
    stringBuffer.append(TEXT_318);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_323);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_319);
    if (isSettingFont) {
    stringBuffer.append(TEXT_320);
    stringBuffer.append(cid );
    } else {
    stringBuffer.append(TEXT_321);
    }
    stringBuffer.append(TEXT_322);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_21);
    
        		}

        	}
        	
        	continue;
        }

    stringBuffer.append(TEXT_324);
    
		if(firstCellYAbsolute){

    stringBuffer.append(TEXT_203);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_204);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_205);
    stringBuffer.append(firstCellXStr);
    stringBuffer.append(TEXT_256);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_56);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_54);
    
				if (isSettingFont) {

    stringBuffer.append(TEXT_207);
    stringBuffer.append(cid );
    
				}

    stringBuffer.append(TEXT_208);
    
		}else{

    stringBuffer.append(TEXT_203);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_204);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_325);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_56);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_54);
    
				if (isSettingFont) {

    stringBuffer.append(TEXT_207);
    stringBuffer.append(cid );
    
				}

    stringBuffer.append(TEXT_209);
    
		}

    stringBuffer.append(TEXT_326);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_211);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_212);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_211);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_213);
    stringBuffer.append(column.getLabel().length());
    stringBuffer.append(TEXT_214);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_211);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_215);
    stringBuffer.append(column.getLabel().length());
    stringBuffer.append(TEXT_27);
    
	}

    stringBuffer.append(TEXT_327);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_328);
    
}

    stringBuffer.append(TEXT_329);
    	
		}else{ //version judgement /***excel 2007 xlsx*****/
			if(!useStream){

    stringBuffer.append(TEXT_330);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_99);
    stringBuffer.append(filename);
    stringBuffer.append(TEXT_27);
    
				if(isDeleteEmptyFile){

    stringBuffer.append(TEXT_331);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_101);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_102);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_103);
    
					if(isAppendFile){

    stringBuffer.append(TEXT_104);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_105);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_106);
    
					}
				}
			}

    stringBuffer.append(TEXT_96);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_332);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_333);
     if (protectFile) { 
    stringBuffer.append(TEXT_334);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_335);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_21);
    }
    	 
		if(flushOnRow && (useStream || !isAppendFile)){

    stringBuffer.append(TEXT_336);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_99);
    stringBuffer.append(flushRowNum);
    stringBuffer.append(TEXT_337);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_338);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_339);
    		
		}
		
		boolean recalculateFormula = "true".equals(ElementParameterParser.getValue(node,"__RECALCULATE_FORMULA__"));

    stringBuffer.append(TEXT_340);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_341);
    stringBuffer.append(sheetname);
    stringBuffer.append(TEXT_342);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_343);
    stringBuffer.append(isAppendFile);
    stringBuffer.append(TEXT_319);
    stringBuffer.append(isAppendSheet);
    stringBuffer.append(TEXT_342);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_344);
    stringBuffer.append(recalculateFormula);
    stringBuffer.append(TEXT_342);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_345);
    stringBuffer.append(firstCellYAbsolute);
    stringBuffer.append(TEXT_319);
    stringBuffer.append(firstCellXStr);
    stringBuffer.append(TEXT_319);
    stringBuffer.append(firstCellYStr);
    stringBuffer.append(TEXT_319);
    stringBuffer.append(keepCellFormating);
    stringBuffer.append(TEXT_346);
    if(!useStream){
    stringBuffer.append(TEXT_347);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_348);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_349);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_350);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_351);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_352);
    
			String rowFileName = filename.replaceAll("\"", "");
            String fileExtension = rowFileName.substring(rowFileName.lastIndexOf(".") + 1);
			if (fileExtension.equalsIgnoreCase("xlsm")){
			
    stringBuffer.append(TEXT_353);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_354);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_21);
    } else {
    stringBuffer.append(TEXT_353);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_355);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_356);
    }
    stringBuffer.append(TEXT_357);
    }else{
    stringBuffer.append(TEXT_340);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_358);
    }
    stringBuffer.append(TEXT_340);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_359);
    stringBuffer.append(font);
    stringBuffer.append(TEXT_360);
    
		int sizeColumns = columns.size();
		if(sizeColumns> schemaOptNum){//TD1

    stringBuffer.append(TEXT_361);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_194);
    
			if(hasDynamic){

    stringBuffer.append(TEXT_362);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_91);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_92);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_196);
    
			}
    		for (int i = 0; isIncludeHeader && (i < sizeColumns); i++) {
    			IMetadataColumn column = columns.get(i);
    			if(i%schemaOptNum==0){

    stringBuffer.append(TEXT_363);
    stringBuffer.append(i/schemaOptNum);
    stringBuffer.append(TEXT_364);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_202);
    
    			}

    stringBuffer.append(TEXT_365);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_366);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_367);
    
    			if((i+1)%schemaOptNum==0){

    stringBuffer.append(TEXT_368);
    
    			}
    		}
    		
    		if(isIncludeHeader && sizeColumns>0 && (sizeColumns%schemaOptNum)>0){

    stringBuffer.append(TEXT_368);
    
    		}
    		
    		boolean emptyMethod = true;
    		for(int i=0;i<sizeColumns;i++){
    			IMetadataColumn column = columns.get(i);
    			if(i%schemaOptNum==0){
    				if(!isAllColumnAutoSize) {
    					if(autoSizeList.size() == columns.size()){
    						for(int j=0;(j<schemaOptNum) && (i+j<sizeColumns);j++) {
        						Map<String,String> tmp= autoSizeList.get(i+j);
        						if(("true").equals(tmp.get("IS_AUTO_SIZE")) && (!columns.get(i+j).getTalendType().equals("id_Dynamic"))){
        							emptyMethod = false;
        							break;
        						}
    						}
    					}
    				} else {
    					emptyMethod = false;
    				}
    				
    				if(!emptyMethod) {

    stringBuffer.append(TEXT_369);
    stringBuffer.append(i/schemaOptNum);
    stringBuffer.append(TEXT_364);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_219);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_220);
        			
					}
    			}
    		if(!column.getTalendType().equals("id_Dynamic")){
    			if(isAllColumnAutoSize){
					if(hasDynamic && i+1>dynamic_index){
					
    stringBuffer.append(TEXT_370);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_222);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_223);
    stringBuffer.append(i-1);
    stringBuffer.append(TEXT_371);
    
					}else{
					
    stringBuffer.append(TEXT_370);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_23);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_371);
    
					}

    stringBuffer.append(TEXT_365);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_372);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_21);
    
    			} else if(autoSizeList.size() == columns.size()) {
    				Map<String,String> tmp= autoSizeList.get(i);
            		if(("true").equals(tmp.get("IS_AUTO_SIZE"))){
						if(hasDynamic && i+1>dynamic_index){
						
    stringBuffer.append(TEXT_233);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_222);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_223);
    stringBuffer.append(i-1);
    stringBuffer.append(TEXT_234);
    
						}else{
						
    stringBuffer.append(TEXT_233);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_23);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_234);
    
						}

    stringBuffer.append(TEXT_365);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_372);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_21);
    
            		}
    			}
    		}
    			if(!emptyMethod && ((i+1)%schemaOptNum==0)){
    				emptyMethod = true;

    stringBuffer.append(TEXT_368);
        			
    			}
    		}
    		if(!emptyMethod && (sizeColumns>0 && (sizeColumns%schemaOptNum)>0)){

    stringBuffer.append(TEXT_368);
        		
    		}
    		
    		for(int i=0;i<sizeColumns;i++){
    			IMetadataColumn column = columns.get(i);
    			if(i%schemaOptNum==0){

    stringBuffer.append(TEXT_373);
    stringBuffer.append(i/schemaOptNum);
    stringBuffer.append(TEXT_237);
    stringBuffer.append(NodeUtil.getPrivateConnClassName(conn) );
    stringBuffer.append(TEXT_238);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_374);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_202);
        			
    			}

    stringBuffer.append(TEXT_375);
    stringBuffer.append(TEXT_376);
    
					JavaType javaType = JavaTypesManager.getJavaTypeFromId(column.getTalendType());
					boolean isPrimitive = JavaTypesManager.isJavaPrimitiveType( javaType, column.isNullable());
					if(!isPrimitive) {
    				
    stringBuffer.append(TEXT_246);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_247);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_248);
    
    				} 
    				
    
					if(!column.getTalendType().equals("id_Dynamic")){
					
    				String pattern = column.getPattern() == null || column.getPattern().trim().length() == 0 ? null : column.getPattern();
    				if (javaType == JavaTypesManager.DATE && pattern != null && pattern.trim().length() != 0) {

    stringBuffer.append(TEXT_377);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_378);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_247);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_68);
    stringBuffer.append(pattern);
    stringBuffer.append(TEXT_21);
    
					} else if(javaType == JavaTypesManager.BYTE_ARRAY){

    stringBuffer.append(TEXT_379);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_380);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_247);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_381);
    
					} else if(advancedSeparator && JavaTypesManager.isNumberType(javaType, column.isNullable())) { 

    stringBuffer.append(TEXT_272);
     if(javaType == JavaTypesManager.BIGDECIMAL) {
    stringBuffer.append(TEXT_377);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_382);
    stringBuffer.append(column.getPrecision() == null? conn.getName() + "." + column.getLabel() : conn.getName() + "." + column.getLabel() + ".setScale(" + column.getPrecision() + ", java.math.RoundingMode.HALF_UP)" );
    stringBuffer.append(TEXT_274);
    stringBuffer.append( thousandsSeparator );
    stringBuffer.append(TEXT_68);
    stringBuffer.append( decimalSeparator );
    stringBuffer.append(TEXT_383);
     } else { 
    stringBuffer.append(TEXT_377);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_382);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_247);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_274);
    stringBuffer.append( thousandsSeparator );
    stringBuffer.append(TEXT_68);
    stringBuffer.append( decimalSeparator );
    stringBuffer.append(TEXT_384);
     } 
    
					} else if (javaType == JavaTypesManager.BIGDECIMAL) {

    stringBuffer.append(TEXT_385);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_386);
    stringBuffer.append(column.getPrecision() == null? conn.getName() + "." + column.getLabel() : conn.getName() + "." + column.getLabel() + ".setScale(" + column.getPrecision() + ", java.math.RoundingMode.HALF_UP)" );
    stringBuffer.append(TEXT_387);
    
					}else if (javaType == JavaTypesManager.BOOLEAN){

    stringBuffer.append(TEXT_377);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_378);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_247);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_21);
    
					}else if (javaType == JavaTypesManager.DOUBLE){

    stringBuffer.append(TEXT_377);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_378);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_247);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_21);
    					}else if(JavaTypesManager.isNumberType(javaType)){

    stringBuffer.append(TEXT_377);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_388);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_247);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_389);
    
					}else{	

    stringBuffer.append(TEXT_377);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_390);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_247);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_186);
    				
					}
					}else{
					
    stringBuffer.append(TEXT_299);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_300);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_247);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_391);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_304);
    
						if("true".equalsIgnoreCase(autColSizeMaping.get(column.getLabel()))){
						
    stringBuffer.append(TEXT_305);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_392);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_304);
    
						}
					}
					if(!isPrimitive) {
    				
    stringBuffer.append(TEXT_393);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_394);
    
    				} 
    				
        			
    			if((i+1)%schemaOptNum==0){

    stringBuffer.append(TEXT_368);
        			
    			}
    		}
    		
    		if(sizeColumns>0 && (sizeColumns%schemaOptNum)>0){

    stringBuffer.append(TEXT_368);
        		
    		}

    stringBuffer.append(TEXT_395);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_309);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_310);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_196);
    
		}//TD1
		
		if(!hasDynamic && isIncludeHeader){
			
			if(!firstCellYAbsolute) {
		
    stringBuffer.append(TEXT_396);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_397);
    
			}
		
    stringBuffer.append(TEXT_340);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_398);
    
			for (int i = 0; i < columns.size(); i++) {
				IMetadataColumn column = columns.get(i);
				if(sizeColumns > schemaOptNum){
        			if(i%schemaOptNum==0){

    stringBuffer.append(TEXT_399);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_317);
    stringBuffer.append(i/schemaOptNum);
    stringBuffer.append(TEXT_400);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_21);
    
        			}
        			continue;
        		}
		
    stringBuffer.append(TEXT_340);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_366);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_360);
    
			}
		
    stringBuffer.append(TEXT_327);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_401);
    
			if(!firstCellYAbsolute) {
		
    stringBuffer.append(TEXT_402);
    
			}
		}	
		
    
		}
    }
}

    stringBuffer.append(TEXT_181);
    return stringBuffer.toString();
  }
}
